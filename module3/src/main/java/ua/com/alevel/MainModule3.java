package ua.com.alevel;

import ua.com.alevel.controller.FinanceManagerController;

public class MainModule3{

    //"root" "" "lesya@i.ua"
    //"root" "" "roma@i.ua"
    public static void main(String[] args){
        new FinanceManagerController(args[0], args[1]).startApp(args[2]);
    }
}
