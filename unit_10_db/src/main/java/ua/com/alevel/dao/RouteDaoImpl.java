package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao{

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteDaoImpl.class);
    public static final String FIND_ALL_ROUTES = "select * from routes";
    private Connection connection;

    public RouteDaoImpl(Connection con){
        this.connection = con;
    }

    @Override
    public List<Route> getAll(){
        List<Route> routes = new ArrayList<>();
        try(Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(FIND_ALL_ROUTES)){
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