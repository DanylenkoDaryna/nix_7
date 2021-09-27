package ua.com.alevel.dao;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.db.LocationTable;
import ua.com.alevel.entity.Location;

import java.util.List;

public class LocationDaoImpl implements LocationDao{

    private LocationTable locationTable = ObjectFactory.getInstance().getImplClass(LocationTable.class);

    @Override
    public List<Location> getAll(){
        return locationTable.getAll();
    }
}
