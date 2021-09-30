package ua.com.alevel.service;

import ua.com.alevel.entity.Location;

import java.sql.Connection;
import java.util.List;

public interface LocationService{

    List<Location> getAll(Connection connection);
}
