package ua.com.alevel.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.controller.FinanceManagerController;
import ua.com.alevel.dto.UserDto;
import ua.com.alevel.entity.Count;
import ua.com.alevel.entity.Operation;
import ua.com.alevel.entity.OperationCategory;

import java.util.List;

public class HibernateService{

    private FinanceServiceHiber financeService;
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateService.class);
    private FinanceManagerController controller;

    public HibernateService(FinanceManagerController fController){
        financeService = new FinanceServiceHiber();
        controller = fController;
    }

    public void addOperation(String userEmail, SessionFactory sessionFactory){
        try(Session entityManager = sessionFactory.openSession()){
            UserDto userDto = financeService.findUser(userEmail, entityManager);
            LOGGER.info("Gaining all info about user {}:{}", userEmail, userDto);
            System.out.println(userDto.toString());
            int countId = controller.chooseCount(userDto);
            Count count = financeService.findCount(countId, entityManager);
            LOGGER.info("Gaining info about user`s count {}:{}", countId, count);
            LOGGER.info("Getting all categories..");
            List<OperationCategory> categoryList = financeService.findAllCategories(entityManager);
            Operation operation = controller.addNewOperation(count, categoryList);
            LOGGER.info("Saving new operation..");
            financeService.saveOperation(operation, entityManager);
        }
    }
}
