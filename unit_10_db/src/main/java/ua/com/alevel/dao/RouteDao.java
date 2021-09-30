package ua.com.alevel.dao;

import ua.com.alevel.entity.Route;

import java.sql.Connection;
import java.util.List;

public interface RouteDao{

    public List<Route> getAll(Connection connection);
}
