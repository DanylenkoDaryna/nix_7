package ua.com.alevel.service;

import ua.com.alevel.dao.ProblemDao;
import ua.com.alevel.entity.Problem;

import java.util.List;

public class ProblemServiceImpl implements ProblemService{

    private static ProblemDao problemDao;

    public ProblemServiceImpl(ProblemDao dao){
        problemDao = dao;
    }

    @Override
    public List<Problem> getAll(){
        return problemDao.getAll();
    }
}
