package ua.com.alevel.service;

import ua.com.alevel.entity.Author;

import java.util.List;

public interface AuthorService{

    void create(Author author);

    Author read(long id);

    List<Author> findAll();

    void update(Author author);

    void delete(long id);
}
