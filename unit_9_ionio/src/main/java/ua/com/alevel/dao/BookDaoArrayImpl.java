package ua.com.alevel.dao;

import ua.com.alevel.db.BookShelfDb;
import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Book;

public class BookDaoArrayImpl implements BookDao{

    private BookDaoArrayImpl(){
        System.out.println("Dao.BookDaoArrayImpl");
    }

    @Override
    public void create(Book book){
        BookShelfDb.getInstance().createBook(book);
    }

    @Override
    public Book read(long id){
        return BookShelfDb.getInstance().readBook(id);
    }

    @Override
    public MyArrayListImpl<Book> findAll(){
        return BookShelfDb.getInstance().readAllBooks();
    }

    @Override
    public void update(Book book){
        BookShelfDb.getInstance().updateBook(book);
    }

    @Override
    public void delete(long id){
        BookShelfDb.getInstance().deleteBook(id);
    }
}
