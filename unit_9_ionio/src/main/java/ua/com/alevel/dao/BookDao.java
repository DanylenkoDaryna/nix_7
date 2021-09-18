package ua.com.alevel.dao;

import ua.com.alevel.entity.Book;

import java.util.List;

public interface BookDao{

    void create(Book book);

    Book read(long id);

    List<Book> findAll();

    void update(Book book);

    void delete(long id);
}
