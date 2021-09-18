package ua.com.alevel.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book extends Entity implements Serializable{

    private String title;
    private String publisher;
    private int pages;
    private List<Author> authors;

    public Book(){
        authors = new ArrayList<>();
    }

    public Book(ArrayList<Author> authors, String title, String publisher, int pages){
        this.title = title;
        this.publisher = publisher;
        this.pages = pages;
        this.authors = authors;
    }

    @Override
    public String toString(){
        return "Book{" +
                "id = " + getId() +
                ", authors = " + authors.toString() +
                ", title = '" + title + '\'' +
                ", publisher = '" + publisher + '\'' +
                ", pages = " + pages +
                '}' + '\n';
    }

    public List<Author> getAuthors(){
        return authors;
    }

    public void setAuthors(List<Author> authors){
        this.authors = authors;
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