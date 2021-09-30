package ua.com.alevel.db;

import ua.com.alevel.entity.Route;

import java.sql.Connection;
import java.util.List;

public interface RouteTable{

    List<Route> getAll(Connection connection);
}
