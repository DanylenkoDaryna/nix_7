package ua.com.alevel.dao;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.db.RouteTable;
import ua.com.alevel.entity.Route;

import java.sql.Connection;
import java.util.List;

public class RouteDaoImpl implements RouteDao{

    private RouteTable routeTable = ObjectFactory.getInstance().getImplClass(RouteTable.class);

    @Override
    public List<Route> getAll(Connection connection){
        return routeTable.getAll(connection);
    }
}
