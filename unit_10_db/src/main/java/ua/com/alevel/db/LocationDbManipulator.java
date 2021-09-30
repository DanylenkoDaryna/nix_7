package ua.com.alevel.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.db.util.Statements;
import ua.com.alevel.entity.Location;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocationDbManipulator implements LocationTable{

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationDbManipulator.class);

    @Override
    public List<Location> getAll(Connection connection){
        List<Location> locations = new ArrayList<>();
        try(Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Statements.FIND_ALL_LOCATIONS)){
            while(rs.next()){
                locations.add(convertIntoLocation(rs));
            }
        }catch(SQLException e){
            LOGGER.error("Problem with getAll() locations Statement", e);
        }
        return locations;
    }

    private Location convertIntoLocation(ResultSet rs) throws SQLException{
        Location location = new Location();
        location.setId(rs.getInt("id"));
        location.setName(rs.getString("name"));
        return location;
    }
}
