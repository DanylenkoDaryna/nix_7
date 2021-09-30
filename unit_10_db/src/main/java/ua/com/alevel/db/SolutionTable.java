package ua.com.alevel.db;

import ua.com.alevel.entity.Solution;

import java.sql.Connection;
import java.util.List;

public interface SolutionTable{

    void addAll(List<Solution> solutions, Connection connection);
}
