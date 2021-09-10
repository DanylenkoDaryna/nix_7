package ua.com.alevel.dao;

import ua.com.alevel.db.FileDb;
import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Book;

public class BookDaoFileImpl implements BookDao{

//    private static FileDb fileDb;
//
//    private static FileDb getFileDb(){
//        return fileDb;
//    }

    public BookDaoFileImpl(){
        System.out.println("Dao.BookDaoFileImpl");
        // fileDb = new FileDb();
    }

    @Override
    public void create(Book book){
        new FileDb().saveBook(book);
    }

    @Override
    public Book read(long id){
        return new FileDb().findBook(id);
    }

    @Override
    public MyArrayListImpl<Book> findAll(){
        return new FileDb().findAllBooks();
    }

    @Override
    public void update(Book book){
        new FileDb().updateBook(book);
    }

    @Override
    public void delete(long id){
        new FileDb().deleteBook(id);
    }
}