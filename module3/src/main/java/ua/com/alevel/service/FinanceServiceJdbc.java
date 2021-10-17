package ua.com.alevel.service;

import ua.com.alevel.dao.FinanceDaoJdbc;
import ua.com.alevel.dto.OperationDto;
import ua.com.alevel.dto.UserDto;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.util.List;

public class FinanceServiceJdbc{

    private FinanceDaoJdbc financeDao;

    FinanceServiceJdbc(){
        financeDao = new FinanceDaoJdbc();
    }

    public UserDto findUser(String email, EntityManager entityManager){
        return financeDao.findUser(email, entityManager);
    }

    public List<OperationDto> getOperations(int countId, Instant start, Instant end, EntityManager entityManager){
        return financeDao.getOperations(countId, start, end, entityManager);
    }
}
