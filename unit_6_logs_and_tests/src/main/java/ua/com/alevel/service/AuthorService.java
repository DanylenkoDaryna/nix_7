package ua.com.alevel.service;

import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;

public interface AuthorService{

    void create(Author author);

    Author read(int id);

    MyArrayListImpl<Author> findAll();

    void update(Author author);

    void delete(int id);
}
