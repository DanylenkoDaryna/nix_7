package ua.com.alevel.db;

import ua.com.alevel.entity.Location;

import java.sql.Connection;
import java.util.List;

public interface LocationTable{

    List<Location> getAll(Connection connection);
}
