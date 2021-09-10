package ua.com.alevel.entity;


import java.io.Serializable;
import java.util.ArrayList;

public class Book extends Entity implements Serializable{

    private ArrayList<Integer> authorsId;
    private String title;
    private String publisher;
    private int pages;

    public Book(){
        authorsId = new ArrayList<>();
    }

    public Book(ArrayList<Integer> authors, String title, String publisher, int pages){
        this.authorsId = authors;
        this.title = title;
        this.publisher = publisher;
        this.pages = pages;
    }

    @Override
    public String toString(){
        return "Book{" +
                "id = " + getId() +
                ", authorsId = " + authorsId +
                ", title = '" + title + '\'' +
                ", publisher = '" + publisher + '\'' +
                ", pages = " + pages +
                '}' + '\n';
    }

    public ArrayList<Integer> getAuthorsId(){
        return authorsId;
    }

    public void setAuthorsId(ArrayList<Integer> authors){
        this.authorsId = authors;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getPublisher(){
        return publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public int getPages(){
        return pages;
    }

    public void setPages(int pages){
        this.pages = pages;
    }
}
