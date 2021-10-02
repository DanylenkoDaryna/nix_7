package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.AppProperties;
import ua.com.alevel.exceptions.PropertyMappingException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class App11Service{
    private static final Logger LOGGER = LoggerFactory.getLogger(App11Service.class);
    private static final String FORMAT_OF_DATE = "dd-mm-yyyy";
    private static final String FILE_PATH = "unit_11_reflection/app.properties";

    public void createAppProperties(){
        LOGGER.info("creating object AppProperties");
        Properties props = getPropertiesFromFile();
        AppProperties appProperties = map(AppProperties.class, props);
        LOGGER.info(appProperties.toString());
    }

    private static Properties getPropertiesFromFile(){
        LOGGER.info("get properties from file");
        Properties props = new Properties();
        try(BufferedReader input = new BufferedReader(new FileReader(FILE_PATH))){
            props.load(input);
        }catch(IOException e){
            LOGGER.error("Can`t get to file!", e);
            throw new UncheckedIOException(e);
        }
        return props;
    }

    private <T> T map(Class<T> objClass, Properties props){
        try{
            T obj = objClass.getConstructor().newInstance();
            fillObject(obj, props);
            return obj;
        }catch(NoSuchMethodException e){
            LOGGER.error("Can`t find this constructor!", e);
            throw new PropertyMappingException(e.getMessage());
        }catch(IllegalAccessException e){
            LOGGER.error("Don`t have access to constructor!", e);
            throw new PropertyMappingException(e.getMessage());
        }catch(InstantiationException e){
            LOGGER.error("Can`t make an instance of this class!", e);
            throw new PropertyMappingException(e.getMessage());
        }catch(InvocationTargetException e){
            LOGGER.error("Can`t invoke!", e);
            throw new PropertyMappingException(e.getMessage());
        }
    }

    private <T> void fillObject(T obj, Properties props){
        Field[] properties = obj.getClass().getDeclaredFields();
        for(Field property : properties){
            if(property.isAnnotationPresent(PropertyKey.class)){
                String fieldNameInProps = property.getAnnotation(PropertyKey.class).value();
                Object propertyValue = getPropertyFromFile(property, fieldNameInProps, props);
                try{
                    property.set(obj, propertyValue);
                }catch(IllegalAccessException e){
                    LOGGER.error(String.format("No acces to %s field!", property.getName()), e);
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static Object getPropertyFromFile(Field field, String fieldNameInProps, Properties props){
        String fieldValue = props.getProperty(fieldNameInProps);
        if(field.getType().equals(String.class)){
            return fieldValue;
        }else if(field.getType().equals(int.class) || field.getType().equals(Integer.class)){
            return Integer.parseInt(fieldValue);
        }else if(field.getType().equals(long.class) || field.getType().equals(Long.class)){
            return Long.parseLong(fieldValue);
        }else if(field.getType().equals(boolean.class) || field.getType().equals(Boolean.class)){
            return Boolean.parseBoolean(fieldValue);
        }else if(field.getType().equals(double.class) || field.getType().equals(Double.class)){
            return Double.parseDouble(fieldValue);
        }else if(field.getType().equals(Date.class)){
            try{
                return new SimpleDateFormat(FORMAT_OF_DATE).parse(fieldValue);
            }catch(ParseException e){
                LOGGER.error("Can`t parse date", e);
                throw new RuntimeException();
            }
        }else if(field.getType().isEnum()){
            return Enum.valueOf((Class<Enum>) field.getType(), fieldValue);
        }
        return fieldValue;
    }
}
