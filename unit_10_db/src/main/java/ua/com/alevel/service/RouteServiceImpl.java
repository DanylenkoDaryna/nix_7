package ua.com.alevel.service;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.dao.RouteDao;
import ua.com.alevel.entity.Route;

import java.util.List;

public class RouteServiceImpl implements RouteService{

    private RouteDao routeDao = ObjectFactory.getInstance().getImplClass(RouteDao.class);

    @Override
    public List<Route> getAllRoutes(){
        return routeDao.getAll();
    }
}
