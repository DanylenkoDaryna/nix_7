package ua.com.alevel.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.db.util.Statements;
import ua.com.alevel.entity.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RouteDbManipulator implements RouteTable{

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteDbManipulator.class);

    @Override
    public List<Route> getAll(Connection connection){
        List<Route> routes = new ArrayList<>();
        try(Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Statements.FIND_ALL_ROUTES)){
            while(rs.next()){
                routes.add(convertIntoLocation(rs));
            }
        }catch(SQLException e){
            LOGGER.error("Problem with getAll() routes statement", e);
        }
        return routes;
    }


    private Route convertIntoLocation(ResultSet rs) throws SQLException{
        Route route = new Route();
        route.setId(rs.getInt("id"));
        route.setFromId(rs.getInt("from_id"));
        route.setToId(rs.getInt("to_id"));
        route.setCost(rs.getInt("cost"));
        return route;
    }
}
