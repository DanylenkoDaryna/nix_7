package ua.com.alevel.service;

import ua.com.alevel.dao.RouteDao;
import ua.com.alevel.entity.Route;

import java.util.List;

public class RouteServiceImpl implements RouteService{

    private RouteDao routeDao;

    public RouteServiceImpl(RouteDao dao){
        this.routeDao = dao;
    }

    @Override
    public List<Route> getAll(){
        return routeDao.getAll();
    }
}
