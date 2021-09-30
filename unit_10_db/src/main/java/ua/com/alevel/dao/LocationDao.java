package ua.com.alevel.dao;

import ua.com.alevel.entity.Location;

import java.sql.Connection;
import java.util.List;

public interface LocationDao{
    List<Location> getAll(Connection connection);
}
