package ua.com.alevel.db;

import ua.com.alevel.entity.Problem;

import java.sql.Connection;
import java.util.List;

public interface ProblemTable{

    List<Problem> getAll(Connection connection);
}
