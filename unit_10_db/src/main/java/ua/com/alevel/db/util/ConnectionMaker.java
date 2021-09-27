package ua.com.alevel.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionMaker{

    private ConnectionMaker(){
        System.out.println("This is util class!");
    }

    public static Connection getConnection() throws SQLException{
        Properties properties = PropertyManager.loadProperties();
        String url = properties.getProperty("url");
        return DriverManager.getConnection(url, properties);
    }
}