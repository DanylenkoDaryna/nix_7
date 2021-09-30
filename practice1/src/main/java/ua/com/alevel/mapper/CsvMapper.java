package ua.com.alevel.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class CsvMapper{

    public void mapObjects(List<String[]> list, Class clazz){
        try{
            for(int i = 0; i < list.size(); i++){
                if(i == 0) continue;
                else{
                    if(!clazz.getConstructor().isAccessible()){
                        clazz.getConstructor().setAccessible(true);
                    }
                    Object result = clazz.getConstructor().newInstance();
                    Field[] objFields = clazz.getDeclaredFields();
                    for(Field fld : objFields){
                        if(fld.isAnnotationPresent(CsvMapping.class)){
                            //Annotation fieldAnnotation = fld.getAnnotation(CsvMapping.class);
                            String csvName = fld.getAnnotation(CsvMapping.class).value();
                            System.out.println(csvName);
                            Field objField = result.getClass().getDeclaredField(csvName);
                            if(!objField.isAccessible()){
                                objField.setAccessible(true);
                            }
                            System.out.println(objField.getType());
                            if(objField.getType().equals("long")){
                                //objField.setLong(result,);
                            }
                        }
                    }
                    System.out.println(clazz.getConstructor().newInstance());
                    System.out.println(result.toString());
                }
            }
        }catch(NoSuchMethodException e){
            System.out.println(e.getMessage());
        }catch(InstantiationException e){
            System.out.println(e.getMessage());
        }catch(IllegalAccessException e){
            System.out.println(e.getMessage());
        }catch(InvocationTargetException e){
            System.out.println(e.getMessage());
        }catch(NoSuchFieldException e){
            System.out.println(e.getMessage());
        }
    }
}
