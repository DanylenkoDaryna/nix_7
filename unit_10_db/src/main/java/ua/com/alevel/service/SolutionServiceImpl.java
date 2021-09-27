package ua.com.alevel.service;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.dao.SolutionDao;
import ua.com.alevel.entity.Solution;

import java.util.List;

public class SolutionServiceImpl implements SolutionService{

    private SolutionDao solutionDao = ObjectFactory.getInstance().getImplClass(SolutionDao.class);

    @Override
    public void addAll(List<Solution> solutions){
        solutionDao.addAll(solutions);
    }
}
