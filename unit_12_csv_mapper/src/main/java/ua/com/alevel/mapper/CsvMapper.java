package ua.com.alevel.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.annotations.CsvMapping;
import ua.com.alevel.entity.CsvTable;
import ua.com.alevel.exceptions.CsvMapperException;
import ua.com.alevel.exceptions.UnknownTypeForMapperException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvMapper{
    private static final Logger LOGGER = LoggerFactory.getLogger(CsvMapper.class);

    public <T> List<T> map(CsvTable csvTable, Class<T> clazz) throws CsvMapperException, UnknownTypeForMapperException{
        List<T> elements = new ArrayList<>();
        for(int i = 0; i < csvTable.getRows().size(); i++){
            T element = makeElement(i, csvTable, clazz);
            elements.add(element);
        }
        return elements;
    }

    private <T> T makeElement(int row, CsvTable csvTable, Class<T> clazz) throws CsvMapperException, UnknownTypeForMapperException{
        try{
            T obj = clazz.getConstructor().newInstance();
            mapElement(row, obj, csvTable);
            return obj;
        }catch(NoSuchMethodException e){
            LOGGER.error("Can`t find this constructor!", e);
            throw new CsvMapperException("Can`t find this constructor!", e);
        }catch(IllegalAccessException e){
            throw new CsvMapperException("Don`t have access to constructor!", e);
        }catch(InstantiationException e){
            throw new CsvMapperException("Can`t make an instance of this class!", e);
        }catch(InvocationTargetException e){
            throw new CsvMapperException("Can`t invoke!", e);
        }
    }

    private <T> T mapElement(int row, T obj, CsvTable csvTable){
        try{
            Field[] objFields = obj.getClass().getDeclaredFields();
            for(Field fld : objFields){
                if(fld.isAnnotationPresent(CsvMapping.class)){
                    if(!fld.isAccessible()){
                        fld.setAccessible(true);
                    }
                    Object value = mapValue(row, fld, csvTable);
                    fld.set(obj, value);
                }
            }
        }catch(IllegalAccessException e){
            throw new CsvMapperException("Illegal Access to one of fields!", e);
        }
        return obj;
    }

    private Object mapValue(int row, Field objField, CsvTable csvTable){
        String fieldAnnotatedName = objField.getAnnotation(CsvMapping.class).value();
        String fieldValue = csvTable.get(row, fieldAnnotatedName);
        if(objField.getType().isEnum()){
            return Enum.valueOf((Class<Enum>) objField.getType(), fieldValue);
        }else if(objField.getType().equals(String.class)){
            return fieldValue;
        }else if(objField.getType().equals(LocalDate.class)){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(fieldValue, formatter);
        }else if(objField.getType().isPrimitive()){
            if(objField.getType().equals(int.class) || objField.getType().equals(Integer.class)){
                return Integer.parseInt(fieldValue);
            }else if(objField.getType().equals(long.class) || objField.getType().equals(Long.class)){
                return Long.parseLong(fieldValue);
            }else if(objField.getType().equals(boolean.class) || objField.getType().equals(Boolean.class)){
                return Boolean.parseBoolean(fieldValue);
            }else if(objField.getType().equals(double.class) || objField.getType().equals(Double.class)){
                return Double.parseDouble(fieldValue);
            }
        }else{
            throw new UnknownTypeForMapperException(String.format("Can`t map field with type %s and name %s"
                    , objField.getType(), objField.getName()));
        }
        return fieldValue;
    }
}
