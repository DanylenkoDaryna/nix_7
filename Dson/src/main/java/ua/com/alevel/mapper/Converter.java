package ua.com.alevel.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class Converter{

    public Converter(){
    }

    public StringBuilder getObjectType(Object obj){
        StringBuilder result = new StringBuilder();
        if(obj.getClass().isAssignableFrom(String.class)){
            result.append("\"")
                    .append(obj)
                    .append("\"");
        }else if(obj.getClass().isPrimitive()){
            //todo
            result.append(obj);
        }else if(isWrapperType(obj.getClass())){
            //todo
            result.append(obj);
        }else if(obj.getClass().getName().contains("List")){
            result.append("[");
            result.append(convertListToJsonStr(obj));
            result.append("]");
        }else if(obj.getClass().isArray()){
            result.append(convertArrayToJsonStr(obj));
        }else if(obj.getClass().isEnum()){
            result.append(convertObjectToJsonStr(obj));
        }else{
            result.append("{");
            result.append(convertObjectToJsonStr(obj));
            result.append("}");
        }
        return result;
    }

    private StringBuilder getFieldType(Object obj){
        StringBuilder result = new StringBuilder();
        if(obj.getClass().isAssignableFrom(String.class)){
            result.append("\"")
                    .append(obj)
                    .append("\"");
        }else if(obj.getClass().isPrimitive()){
            result.append(obj);
        }else if(isWrapperType(obj.getClass())){
            result.append(obj);
        }else if(obj.getClass().getName().contains("List")){
            result.append("[");
            result.append(convertListToJsonStr(obj));
            result.append("]");
        }else if(obj.getClass().isArray()){
            result.append(convertArrayToJsonStr(obj));
        }else{
            result.append("{");
            result.append(convertObjectToJsonStr(obj));
            result.append("}");
        }
        return result;
    }

    private static boolean isWrapperType(Class<?> clazz){
        return getWrapperTypes().contains(clazz);
    }

    private static Set<Class<?>> getWrapperTypes(){
        Set<Class<?>> wrappers = new HashSet<Class<?>>();
        wrappers.add(Boolean.class);
        wrappers.add(Character.class);
        wrappers.add(Byte.class);
        wrappers.add(Short.class);
        wrappers.add(Integer.class);
        wrappers.add(Long.class);
        wrappers.add(Float.class);
        wrappers.add(Double.class);
        wrappers.add(Void.class);
        return wrappers;
    }

    private StringBuilder convertListToJsonStr(Object mainObj){
        StringBuilder result = new StringBuilder();
        try{
            int size = Integer.parseInt(mainObj.getClass().getDeclaredMethod("size").invoke(mainObj).toString());
            for(int i = 0; i < size; i++){
                result.append(getFieldType(mainObj.getClass().getDeclaredMethod("get", int.class)
                        .invoke(mainObj, i)));
                if(i != size - 1){
                    result.append(",");
                }
            }
        }catch(NoSuchMethodException ex){
            ex.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch(InvocationTargetException e){
            e.printStackTrace();
        }
        return result;
    }

    private StringBuilder convertObjectToJsonStr(Object object){
        StringBuilder result = new StringBuilder();
        try{
            if(!object.getClass().getSuperclass().equals(Object.class)){
                Field[] superFields = object.getClass().getSuperclass().getDeclaredFields();
                for(int j = 0; j < superFields.length; j++){
                    result.append("\"")
                            .append(superFields[j].getName())
                            .append("\"")
                            .append(":");
                    if(superFields[j].isAccessible()){
                        result.append(getFieldType(superFields[j].get(object)));
                    }else{
                        superFields[j].setAccessible(true);
                        result.append(getFieldType(superFields[j].get(object)));
                    }
                    result.append(",");
                }
            }
            Field[] fields = object.getClass().getDeclaredFields();
            for(int i = 0; i < fields.length; i++){
                result.append("\"")
                        .append(fields[i].getName())
                        .append("\"")
                        .append(":");
                if(fields[i].isAccessible()){
                    result.append(getFieldType(fields[i].get(object)));
                }else{
                    fields[i].setAccessible(true);
                    result.append(getFieldType(fields[i].get(object)));
                }
                if(i != fields.length - 1){
                    result.append(",");
                }
            }
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }
        return result;
    }

    private StringBuilder convertArrayToJsonStr(Object obj){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n[\n");
        try{

            for(int i = 0; i < Integer.parseInt(obj.getClass().getDeclaredField("length").get(obj).toString()); i++){

            }
        }catch(NoSuchFieldException ex){
            ex.printStackTrace();
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
        }
        stringBuilder.append("\n]\n");
        return stringBuilder;
    }
}