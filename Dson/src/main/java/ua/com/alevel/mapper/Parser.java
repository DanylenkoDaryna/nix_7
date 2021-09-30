package ua.com.alevel.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Parser{

    public Object parseObject(String jsonString, Class clazz){
        JsonElement jsonElement = new Gson().fromJson(jsonString, JsonObject.class);
        Object result = null;
        try{
            if(jsonElement instanceof JsonObject){
                JsonObject jsonObj = jsonElement.getAsJsonObject();
                if(clazz.getConstructor().isAccessible()){
                    result = clazz.getConstructor().newInstance();
                }else{
                    clazz.getConstructor().setAccessible(true);
                    result = clazz.getConstructor().newInstance();
                }

                if(!clazz.getSuperclass().equals(Object.class)){
                    fillSuperFields(jsonObj, clazz, result);
                    fillSimpleFields(jsonObj, clazz, result);
                }else{
                    fillSimpleFields(jsonObj, clazz, result);
                }
            }else if(jsonElement instanceof JsonArray){
            }
        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch(InstantiationException e){
            e.printStackTrace();
        }catch(InvocationTargetException e){
            e.printStackTrace();
        }
        return result;
    }

    private void fillSimpleFields(JsonObject jsonObj, Class clazz, Object result){
        int superFieldsCount = clazz.getSuperclass().getDeclaredFields().length;
        try{
            for(Map.Entry<String, JsonElement> entry : jsonObj.entrySet()){
                if(superFieldsCount > 0){
                    superFieldsCount--;
                    continue;
                }
                JsonElement value = entry.getValue();
                if(value.isJsonPrimitive()){
                    String primitive = value.getAsString();
                    if(primitive.matches("\\d+")){
                        Field tempField = result.getClass().getDeclaredField(entry.getKey());
                        tempField.setAccessible(true);
                        Type fieldType = result.getClass().getDeclaredField(entry.getKey()).getType();
                        switch(fieldType.getTypeName()){
                            case "long":{
                                Long aLong = Long.parseLong(primitive);
                                tempField.setLong(result, aLong);
                                break;
                            }
                            case "int":{
                                Integer aInt = Integer.parseInt(primitive);
                                tempField.setInt(result, aInt);
                                break;
                            }
                            case "short":
                            case "byte":
                            case "double":
                            case "float":
                        }
                    }else if(value.toString().matches("\".*\"")){
                        String fieldVal = value.getAsJsonPrimitive().getAsString();
                        Field tempField = result.getClass().getDeclaredField(entry.getKey());
                        tempField.setAccessible(true);
                        tempField.set(result, fieldVal);
                    }
                }
                if(value.isJsonObject()){
                }
                if(value.isJsonArray()){
                    Field tempField = result.getClass().getDeclaredField(entry.getKey());
                    tempField.setAccessible(true);
                    Type listType = result.getClass().getDeclaredField(entry.getKey()).getType();
                    switch(listType.getTypeName()){
                        case "java.mapper.List":{
                            ParameterizedType paramListType = (ParameterizedType) tempField.getGenericType();
                            Class<?> listClass = (Class<?>) paramListType.getActualTypeArguments()[0];
                            ArrayList list = (ArrayList) parseArray(value, listClass);
                            tempField.set(result, list);
                            break;
                        }
                    }
                }
            }
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch(NoSuchFieldException e){
            e.printStackTrace();
        }
    }

    private List parseArray(JsonElement arrayElement, Class listElementType){
        List list = null;
        list = new ArrayList();
        int size = arrayElement.getAsJsonArray().size();
        for(int i = 0; i < size; i++){
            Object element = arrayElement.getAsJsonArray().get(i);
            Object resultElement = parseObject(element.toString(), listElementType);
            list.add(resultElement);
        }
        return list;
    }

    private void fillSuperFields(JsonObject jsonObj, Class clazz, Object result){
        int countOfSuperFields = clazz.getSuperclass().getDeclaredFields().length + 1;
        try{
            for(Map.Entry<String, JsonElement> entry : jsonObj.entrySet()){
                if(countOfSuperFields > 0){
                    JsonElement value = entry.getValue();
                    if(value.isJsonPrimitive()){
                        String primitive = value.getAsString();
                        if(primitive.matches("\\d+")){
                            Field tempField = result.getClass().getSuperclass().getDeclaredField(entry.getKey());
                            tempField.setAccessible(true);
                            Type fieldType = tempField.getType();
                            switch(fieldType.getTypeName()){
                                case "long":{
                                    Long aLong = Long.parseLong(primitive);
                                    tempField.setLong(result, aLong);
                                    break;
                                }
                            }
                        }else if(value.toString().matches("\".*\"")){
                            String fieldVal = value.getAsJsonPrimitive().getAsString();
                            Field tempField = result.getClass().getDeclaredField(entry.getKey());
                            tempField.setAccessible(true);
                            tempField.set(result, fieldVal);
                        }
                    }else if(value.isJsonObject()){
                    }else if(value.isJsonArray()){
                    }
                    countOfSuperFields--;
                }
                break;
            }
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch(NoSuchFieldException e){
            e.printStackTrace();
        }
    }

    public List<? extends Object> parseList(String jsonString, Class<ArrayList> listType, Class<?> classType){
        JsonElement jsonElement = new Gson().fromJson(jsonString, JsonArray.class);
        return parseArray(jsonElement, classType);
    }
}
