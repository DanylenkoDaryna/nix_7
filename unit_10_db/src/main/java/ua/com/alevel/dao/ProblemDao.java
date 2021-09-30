package ua.com.alevel.dao;

import ua.com.alevel.entity.Problem;

import java.sql.Connection;
import java.util.List;

public interface ProblemDao{
    List<Problem> getAll(Connection connection);
}
