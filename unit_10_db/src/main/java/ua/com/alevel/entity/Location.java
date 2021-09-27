package ua.com.alevel.entity;

public class Location extends Entity{

    private String name;

    public Location(){
    }

    public Location(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
