package ua.com.alevel.dao;

import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Book;

public interface BookDao{

    void create(Book book);

    Book read(int id);

    MyArrayListImpl<Book> findAll();

    void update(Book book);

    void delete(int id);
}
