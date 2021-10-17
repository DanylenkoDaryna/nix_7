package ua.com.alevel.service;

import ua.com.alevel.dao.FinanceDaoHiber;
import ua.com.alevel.dto.UserDto;
import ua.com.alevel.entity.Count;
import ua.com.alevel.entity.Operation;
import ua.com.alevel.entity.OperationCategory;

import javax.persistence.EntityManager;
import java.util.List;

public class FinanceServiceHiber{

    private FinanceDaoHiber financeDao;

    FinanceServiceHiber(){
        financeDao = new FinanceDaoHiber();
    }

    public UserDto findUser(String email, EntityManager entityManager){
        return financeDao.findUser(email, entityManager);
    }

    public Count findCount(int id, EntityManager entityManager){
        return financeDao.findCount(id, entityManager);
    }


    public void saveOperation(Operation operation, EntityManager entityManager){
        financeDao.saveOperation(operation, entityManager);
    }

    public List<OperationCategory> findAllCategories(EntityManager entityManager){
        return financeDao.findAllCategories(entityManager);
    }
}