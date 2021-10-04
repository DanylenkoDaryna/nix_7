package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.AppProperties;
import ua.com.alevel.util.PropertyMapper;

import java.util.Properties;

public class App11Service{
    private static final Logger LOGGER = LoggerFactory.getLogger(App11Service.class);

    public void createAppProperties(String filePathToProps){
        PropertyMapper propertyMapper = new PropertyMapper();
        LOGGER.info("getting properties from file..");
        Properties props = propertyMapper.getPropertiesFromFile(filePathToProps);
        LOGGER.info("creating AppProperties object...");
        AppProperties appProperties = propertyMapper.map(AppProperties.class, props);
        LOGGER.info(appProperties.toString());
    }
}
