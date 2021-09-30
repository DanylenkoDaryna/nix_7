package ua.com.alevel.service;

import ua.com.alevel.entity.Route;

import java.sql.Connection;
import java.util.List;

public interface RouteService{

    public List<Route> getAll(Connection connection);
}
