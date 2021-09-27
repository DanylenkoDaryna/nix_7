package ua.com.alevel.dao;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.db.SolutionTable;
import ua.com.alevel.entity.Solution;

import java.util.List;

public class SolutionDaoImpl implements SolutionDao{

    private SolutionTable solutionTable = ObjectFactory.getInstance().getImplClass(SolutionTable.class);

    @Override
    public void addAll(List<Solution> solutions){
        solutionTable.addAll(solutions);
    }
}
