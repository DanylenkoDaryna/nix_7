package ua.com.alevel.entity;


public class Author{

    private int id;
    private String fullName;

    public Author(){
    }

    public Author(String fullName){
        this.fullName = fullName;
    }

    @Override
    public String toString(){
        return "Author{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }
}
