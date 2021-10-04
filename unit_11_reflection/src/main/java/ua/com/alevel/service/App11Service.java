package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.AppProperties;
import ua.com.alevel.util.PropertyMapper;

import java.util.Properties;

public class App11Service{
    private static final Logger LOGGER = LoggerFactory.getLogger(App11Service.class);
    private static final String FILE_PATH = "unit_11_reflection/files/app.properties";

    public void createAppProperties(){
        PropertyMapper propertyMapper = new PropertyMapper();
        LOGGER.info("getting properties from file..");
        Properties props = propertyMapper.getPropertiesFromFile(FILE_PATH);
        LOGGER.info("creating AppProperties object...");
        AppProperties appProperties = propertyMapper.map(AppProperties.class, props);
        LOGGER.info(appProperties.toString());
    }
}
