package ua.com.alevel.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionMaker{

    private ConnectionMaker(){
        System.out.println("This is util class!");
    }

    public static Connection getConnection(String pathToProps) throws SQLException{
        Properties properties = PropertyManager.loadProperties(pathToProps);
        String url = properties.getProperty("url");
        return DriverManager.getConnection(url, properties);
    }
}