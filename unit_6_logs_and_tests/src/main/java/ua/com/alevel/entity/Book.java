package ua.com.alevel.entity;

import ua.com.alevel.db.MyArrayListImpl;

public class Book{

    private int id;
    private MyArrayListImpl<Author> authors;
    private String title;
    private String publisher;
    private int pages;

    public Book(){
        authors = new MyArrayListImpl<>();
    }

    public Book(MyArrayListImpl<Author> authors, String title, String publisher, int pages){
        this.authors = authors;
        this.title = title;
        this.publisher = publisher;
        this.pages = pages;
    }

    @Override
    public String toString(){
        return "Book{" +
                "id=" + id +
                ", authorsId=" + authors +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pages=" + pages +
                '}' + '\n';
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public MyArrayListImpl<Author> getAuthors(){
        return authors;
    }

    public void setAuthors(MyArrayListImpl<Author> authors){
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
