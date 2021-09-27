package ua.com.alevel.service;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.dao.LocationDao;
import ua.com.alevel.entity.Location;

import java.util.List;

public class LocationServiceImpl implements LocationService{

    private LocationDao locationDao = ObjectFactory.getInstance().getImplClass(LocationDao.class);

    @Override
    public List<Location> getAll(){
        return locationDao.getAll();
    }


}
