package ua.com.alevel.dao;

import ua.com.alevel.db.BookShelfDb;
import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Book;

public class BookDaoArrayImpl{

    private BookDaoArrayImpl(){
        System.out.println("Dao.BookDaoArrayImpl");
    }

    public void create(Book book){
        BookShelfDb.getInstance().createBook(book);
    }

    public Book read(long id){
        return BookShelfDb.getInstance().readBook(id);
    }

    public MyArrayListImpl<Book> findAll(){
        return BookShelfDb.getInstance().readAllBooks();
    }

    public void update(Book book){
        BookShelfDb.getInstance().updateBook(book);
    }

    public void delete(long id){
        BookShelfDb.getInstance().deleteBook(id);
    }
}
