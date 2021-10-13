package ua.com.alevel.controller;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dto.LessonDto;
import ua.com.alevel.service.LessonService;
import ua.com.alevel.service.LessonServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Unit13Controller{

    private static final Logger LOGGER = LoggerFactory.getLogger(Unit13Controller.class);
    private SessionFactory sessionFactory;
    private LessonService lessonServise;

    public void start(){
        showMenu();
    }

    public Unit13Controller(){
    }

    public Unit13Controller(SessionFactory factory){
        this.sessionFactory = factory;
        lessonServise = new LessonServiceImpl(sessionFactory);
    }

    private void showMenu(){
        boolean menuCycleBreaker = true;
        while(menuCycleBreaker){
            System.out.println("Choose an option:");
            System.out.println("0 - exit");
            System.out.println("1 - to get next nearest lesson by Student id");
            String input = getUsersPreEditedCommand();
            switch(input){
                case "0":
                    menuCycleBreaker = false;
                    break;
                case "1":
                    getNextLesson();
                    break;
                default:
                    LOGGER.error("Incorrect input! Please, try again...");
            }
        }
    }

    private void getNextLesson(){
        long inputId = enterId();
        LOGGER.info("User interested in id = {}", inputId);
        LessonDto nextLesson = lessonServise.getNextLesson(inputId);
        System.out.println(nextLesson.toString());

    }

    private static BufferedReader getReader(){
        BufferedReader mainReader = null;
        try{
            mainReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        }catch(UnsupportedEncodingException e){
            LOGGER.error("Problem in main conroller", e);
        }
        return mainReader;
    }

    private static String getUsersPreEditedCommand(){
        try{
            return getReader().readLine().trim().toLowerCase().replaceAll(" ", "");
        }catch(NullPointerException e){
            LOGGER.error("method getReader() returned null", e);
            return getUsersPreEditedCommand();
        }catch(IOException e){
            LOGGER.error("Can`t read from input", e);
            return getUsersPreEditedCommand();
        }
    }

    private static String getUsersPreEditedInput(){
        try{
            return getReader().readLine().trim();
        }catch(NullPointerException e){
            LOGGER.error("method getReader() returned null", e);
            return getUsersPreEditedCommand();
        }catch(IOException e){
            LOGGER.error("Can`t read from input", e);
            return getUsersPreEditedInput();
        }
    }

    private long enterId(){
        System.out.println("Please, enter id..");
        String id = getUsersPreEditedInput();
        return checkId(id);
    }

    private long checkId(String id){
        if(isIdMatchesRules(id)){
            return Long.parseLong(id);
        }else{
            LOGGER.error("Wrong! Need a correct id number");
            return enterId();
        }
    }

    private boolean isIdMatchesRules(String id){
        return id.matches("^[0-9]+$");
    }
}
