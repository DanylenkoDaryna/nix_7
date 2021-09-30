package ua.com.alevel.service;

import ua.com.alevel.entity.Problem;

import java.sql.Connection;
import java.util.List;

public interface ProblemService{

    List<Problem> getAll(Connection connection);
}
