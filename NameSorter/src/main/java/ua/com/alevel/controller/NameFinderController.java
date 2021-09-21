package ua.com.alevel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.cmd.NFMessages;

import java.io.*;
import java.util.*;

public class NameFinderController{

    private static final String PATH_TO_FILE_WITH_NAMES = "module2/files/names.txt";
    private static final Logger LOGGER_ERR = LoggerFactory.getLogger("error");

    public void findName(){
        System.out.println("Looking for unique name from 'names.txt'...");
        List<String> names = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader
                (new FileReader(PATH_TO_FILE_WITH_NAMES))){
            while(bufferedReader.ready()){
                String line = bufferedReader.readLine().trim();
                if(checkSaneName(line)){
                    names.add(line);
                    System.out.println(line);
                }
            }
            System.out.println("first unique name = " + findFirstUnique(names));
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }catch(NullPointerException ne){
            LOGGER_ERR.error(ne.getMessage());
        }
    }

    private static String findFirstUnique(List<String> names){
        LinkedHashMap<String, Integer> mapOfNames = new LinkedHashMap<>();
        for(String name : names){
            if(mapOfNames.containsKey(name)){
                int count = mapOfNames.get(name);
                count++;
                mapOfNames.put(name, count);
            }else mapOfNames.put(name, 0);
        }

        for(Map.Entry<String, Integer> tempName : mapOfNames.entrySet()){
            if(tempName.getValue() == 0){
                return tempName.getKey();
            }
        }
        return "No one name is unique!";
    }

    private boolean checkSaneName(String name){
        return name.matches(NFMessages.REGEX_FOR_SANE_NAME);
    }
}