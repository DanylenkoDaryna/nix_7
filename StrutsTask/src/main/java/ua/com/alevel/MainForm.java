package ua.com.alevel;

import org.apache.struts.action.ActionForm;

public class MainForm extends ActionForm{

    String message;

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
