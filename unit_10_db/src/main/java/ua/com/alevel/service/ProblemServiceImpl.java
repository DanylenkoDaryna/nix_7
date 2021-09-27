package ua.com.alevel.service;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.dao.ProblemDao;
import ua.com.alevel.entity.Problem;

import java.util.List;

public class ProblemServiceImpl implements ProblemService{

    private static ProblemDao problemDao = ObjectFactory.getInstance().getImplClass(ProblemDao.class);

    @Override
    public List<Problem> getAll(){
        return problemDao.getAll();
    }
}
