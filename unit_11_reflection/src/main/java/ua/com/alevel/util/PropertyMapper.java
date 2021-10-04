package ua.com.alevel.util;

import ua.com.alevel.annotations.PropertyKey;
import ua.com.alevel.exceptions.PropertyMappingException;
import ua.com.alevel.exceptions.PropertyParsingException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class PropertyMapper{

    private static final String FORMAT_OF_DATE = "dd-mm-yyyy";

    public Properties getPropertiesFromFile(String filePath){
        Properties props = new Properties();
        try(BufferedReader input = new BufferedReader(new FileReader(filePath))){
            props.load(input);
        }catch(IOException e){
            throw new PropertyParsingException("Can`t get to file!", e);
        }
        return props;
    }

    public <T> T map(Class<T> objClass, Properties props){
        try{
            T obj = objClass.getConstructor().newInstance();
            fillObject(obj, props);
            return obj;
        }catch(NoSuchMethodException e){
            throw new PropertyMappingException("Can`t find this constructor!", e);
        }catch(IllegalAccessException e){
            throw new PropertyMappingException("Don`t have access to constructor!", e);
        }catch(InstantiationException e){
            throw new PropertyMappingException("Can`t make an instance of this class!", e);
        }catch(InvocationTargetException e){
            throw new PropertyMappingException("Can`t invoke!", e);
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
                    throw new PropertyMappingException(String.format
                            ("No acces to %s field!", property.getName()), e);
                }
            }
        }
    }

    private Object getPropertyFromFile(Field field, String fieldNameInProps, Properties props){
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
                throw new PropertyMappingException("Can`t parse date", e);
            }
        }else if(field.getType().isEnum()){
            return Enum.valueOf((Class<Enum>) field.getType(), fieldValue);
        }
        return fieldValue;
    }
}
