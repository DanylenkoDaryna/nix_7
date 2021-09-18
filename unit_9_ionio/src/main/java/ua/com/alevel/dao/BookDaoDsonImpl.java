package ua.com.alevel.dao;

import ua.com.alevel.db.MyJsonConverterFileDb;
import ua.com.alevel.entity.Book;

import java.util.List;

public class BookDaoDsonImpl implements BookDao{

    private static MyJsonConverterFileDb fileDb;

    private static MyJsonConverterFileDb getInstance(){
        if(fileDb == null){
            fileDb = new MyJsonConverterFileDb();
        }
        return fileDb;
    }

    @Override
    public void create(Book book){
        getInstance().saveBook(book);
    }

    @Override
    public Book read(long id){
        return getInstance().findBook(id);
    }

    @Override
    public List<Book> findAll(){
        return getInstance().findAllBooks();
    }

    @Override
    public void update(Book book){
        getInstance().updateBook(book);
    }

    @Override
    public void delete(long id){
        getInstance().deleteBook(id);
    }
}
