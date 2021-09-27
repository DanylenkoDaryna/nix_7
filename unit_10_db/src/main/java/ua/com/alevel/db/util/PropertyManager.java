package ua.com.alevel.db.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Properties;

public class PropertyManager{

    private PropertyManager(){
        System.out.println("This is util class!");
    }

    public static Properties loadProperties(){
        Properties props = new Properties();
        try(InputStream stream = PropertyManager.class.getResourceAsStream("/jdbc.properties")){
            props.load(stream);
        }catch(IOException e){
            throw new UncheckedIOException(e);
        }
        return props;
    }
}