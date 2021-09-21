package ua.com.alevel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.cmd.AppMessages;

import java.io.*;

public class Module2Controller{

    private static final Logger LOGGER_ERR = LoggerFactory.getLogger("error");

    private static BufferedReader getReader(){
        BufferedReader mainReader = null;
        try{
            mainReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        }catch(UnsupportedEncodingException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
        return mainReader;
    }

    public static String getUsersPreEditedCommand(){
        try{
            return getReader().readLine().trim().toLowerCase()
                    .replaceAll(AppMessages.SPACE, AppMessages.NO_SPACE);
        }catch(NullPointerException ne){
            System.out.println("method getReader() returned null");
            return getUsersPreEditedCommand();
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
            return getUsersPreEditedCommand();
        }
    }

    public void startApp(){
        MenuController.startAppMenu(this);
    }

    void checkMenuInput(){
        MenuController.chooseOption();
    }
}