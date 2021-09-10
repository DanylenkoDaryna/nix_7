package ua.com.alevel.service;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Book;


public class BookServiceImpl implements BookService{

    private final BookDao bookDao =
            ObjectFactory.getInstance().getImplClass(BookDao.class);

    @Override
    public void create(Book book){
        bookDao.create(book);
    }

    @Override
    public Book read(long id){
        return bookDao.read(id);
    }

    @Override
    public MyArrayListImpl<Book> findAll(){
        return bookDao.findAll();
    }

    @Override
    public void update(Book book){
        bookDao.update(book);
    }

    @Override
    public void delete(long id){
        bookDao.delete(id);
    }
}
