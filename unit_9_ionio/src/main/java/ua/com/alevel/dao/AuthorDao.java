package ua.com.alevel.dao;

import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;

import java.util.List;

public interface AuthorDao{

    void create(Author author);

    Author read(long id);

    List<Author> findAll();

    void update(Author author);

    void delete(long id);
}
