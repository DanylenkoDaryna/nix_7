package ua.com.alevel.dao;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.db.ProblemTable;
import ua.com.alevel.entity.Problem;

import java.util.List;

public class ProblemDaoImpl implements ProblemDao{

    private ProblemTable problemTable = ObjectFactory.getInstance().getImplClass(ProblemTable.class);

    @Override
    public List<Problem> getAll(){
        return problemTable.getAll();
    }
}
