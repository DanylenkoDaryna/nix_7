package ua.com.alevel.service;

import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Book;

public interface BookService{

    void create(Book book);

    Book read(int id);

    MyArrayListImpl<Book> findAll();

    void update(Book book);

    void delete(int id);
}
