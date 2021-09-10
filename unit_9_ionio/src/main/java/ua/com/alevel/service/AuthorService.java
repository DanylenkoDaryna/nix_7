package ua.com.alevel.service;

import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;

public interface AuthorService{

    void create(Author author);

    Author read(long id);

    MyArrayListImpl<Author> findAll();

    void update(Author author);

    void delete(long id);
}
