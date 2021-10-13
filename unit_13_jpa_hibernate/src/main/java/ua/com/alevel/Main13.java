package ua.com.alevel;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.com.alevel.controller.Unit13Controller;

public class Main13{

    public static void main(String[] args){
        Configuration configuration = new Configuration().configure();
        try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
            new Unit13Controller(sessionFactory).start();
        }
    }
}