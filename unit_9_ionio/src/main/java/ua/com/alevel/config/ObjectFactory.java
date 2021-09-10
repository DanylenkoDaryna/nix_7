package ua.com.alevel.config;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ObjectFactory{

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
    private final Reflections reflections = new Reflections("ua.com.alevel");

    private ObjectFactory(){
        System.out.println("ObjectFactory created");
    }

    public static ObjectFactory getInstance(){
        return OBJECT_FACTORY;
    }

    //todo
    public <T> T getImplClass(Class<T> tClass){
        Set<Class<? extends T>> objects = reflections.getSubTypesOf(tClass);
        for(Class<?> object : objects){
            try{
                return (T) object.getDeclaredConstructor().newInstance();
            }catch(InstantiationException e){
                //e.printStackTrace();
                System.out.println("Ha-ha-ha, I`m InstantiationException joker");
            }catch(IllegalAccessException e){
                // e.printStackTrace();
                System.out.println("Ha-ha-ha, I`m IllegalAccessException joker");
            }catch(InvocationTargetException e){
                // e.printStackTrace();
                System.out.println("Ha-ha-ha, I`m InvocationTargetException joker");
            }catch(NoSuchMethodException e){
                // e.printStackTrace();
                System.out.println("Ha-ha-ha, I`m NoSuchMethodException joker");
            }
        }
        throw new RuntimeException("implementations not found!!!111");
    }
}
