package ua.com.alevel.entity;


import java.io.Serializable;
import java.util.ArrayList;

public class Author extends Entity implements Serializable{

    private String fullName;
    private ArrayList<Integer> booksId;

    public Author(){
    }

    public Author(String fullName){
        this.fullName = fullName;
    }

    @Override
    public String toString(){
        return "Author{" +
                "id=" + getId() +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }
}
