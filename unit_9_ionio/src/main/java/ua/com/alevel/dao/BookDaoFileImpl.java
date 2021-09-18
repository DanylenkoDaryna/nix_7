package ua.com.alevel.dao;

import ua.com.alevel.db.GsonConverterFileDb;
import ua.com.alevel.entity.Book;

import java.util.List;

public class BookDaoFileImpl
//        implements BookDao
{

    private static GsonConverterFileDb fileDb;

    private static GsonConverterFileDb getInstance(){
        if(fileDb == null){
            fileDb = new GsonConverterFileDb();
        }
        return fileDb;
    }

    public BookDaoFileImpl(){
        System.out.println("Dao.BookDaoFileImpl");
    }

    //    @Override
    public void create(Book book){
        getInstance().saveBook(book);
    }

    //    @Override
    public Book read(long id){
        return getInstance().findBook(id);
    }

    //    @Override
    public List<Book> findAll(){
        return getInstance().findAllBooks();
    }

    //    @Override
    public void update(Book book){
        getInstance().updateBook(book);
    }

    //    @Override
    public void delete(long id){
        getInstance().deleteBook(id);
    }
}