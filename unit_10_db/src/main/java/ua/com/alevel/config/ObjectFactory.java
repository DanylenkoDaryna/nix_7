package ua.com.alevel.config;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ObjectFactory{

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
    private final Reflections reflections = new Reflections("ua.com.alevel");
    private static final Logger LOGGER_ERR = LoggerFactory.getLogger("error");


    private ObjectFactory(){
    }

    public static ObjectFactory getInstance(){
        return OBJECT_FACTORY;
    }

    public <T> T getImplClass(Class<T> tClass){
        Set<Class<? extends T>> objects = reflections.getSubTypesOf(tClass);
        for(Class<?> object : objects){
            try{
                return (T) object.getDeclaredConstructor().newInstance();
            }catch(InstantiationException e){
                LOGGER_ERR.error(e.getMessage());
            }catch(IllegalAccessException e){
                LOGGER_ERR.error(e.getMessage());
            }catch(InvocationTargetException e){
                LOGGER_ERR.error(e.getMessage());
            }catch(NoSuchMethodException e){
                LOGGER_ERR.error(e.getMessage());
            }
        }
        throw new RuntimeException("implementations not found!!!");
    }
}
