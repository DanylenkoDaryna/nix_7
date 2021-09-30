package ua.com.alevel.dao;

import ua.com.alevel.entity.Solution;

import java.sql.Connection;
import java.util.List;

public interface SolutionDao{

    void addAll(List<Solution> solutions, Connection connection);
}
