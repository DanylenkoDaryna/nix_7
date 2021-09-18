package ua.com.alevel;


import ua.com.alevel.util.Converter;
import ua.com.alevel.util.Parser;

import java.util.ArrayList;
import java.util.List;

public class Dson{

    public Dson(){
    }

    public String convertToJson(Object object){
        return new Converter().getObjectType(object).toString();
    }


    public Object parseObjectFromJson(String jsonString, Class clazz){
        return new Parser().parseObject(jsonString, clazz);
    }

    public List<? extends Object> parseListFromJson(String jsonString, Class<ArrayList> listType,
                                                    Class<? extends Object> classType){
        return new Parser().parseList(jsonString, listType, classType);
    }
}
