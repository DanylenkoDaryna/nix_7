package ua.com.alevel.dao;

import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;

public interface AuthorDao{

    void create(Author author);

    Author read(long id);

    MyArrayListImpl<Author> findAll();

    void update(Author author);

    void delete(long id);
}
