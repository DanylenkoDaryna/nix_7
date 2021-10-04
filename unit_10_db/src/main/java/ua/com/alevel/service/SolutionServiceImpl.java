package ua.com.alevel.service;

import ua.com.alevel.dao.SolutionDao;
import ua.com.alevel.entity.Solution;

import java.util.List;

public class SolutionServiceImpl implements SolutionService{

    private SolutionDao solutionDao;

    public SolutionServiceImpl(SolutionDao dao){
        this.solutionDao = dao;
    }

    @Override
    public void addAll(List<Solution> solutions){
        solutionDao.addAll(solutions);
    }
}
