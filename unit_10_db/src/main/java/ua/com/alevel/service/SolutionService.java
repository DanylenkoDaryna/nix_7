package ua.com.alevel.service;

import ua.com.alevel.entity.Solution;

import java.sql.Connection;
import java.util.List;

public interface SolutionService{

    void addAll(List<Solution> solutions, Connection connection);
}
