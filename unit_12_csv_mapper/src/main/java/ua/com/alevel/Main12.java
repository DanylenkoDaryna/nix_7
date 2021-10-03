package ua.com.alevel;

import ua.com.alevel.controllers.App12Controller;

public class Main12{

    public static void main(String[] args){
        String pathToFile = args[0];
        App12Controller controller = new App12Controller();
        controller.start(pathToFile);
    }
}
