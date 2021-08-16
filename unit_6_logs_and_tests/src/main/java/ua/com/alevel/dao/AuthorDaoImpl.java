package ua.com.alevel.dao;

import ua.com.alevel.db.BookShelfDb;
import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;

public class AuthorDaoImpl implements AuthorDao{


    @Override
    public void create(Author author){
        BookShelfDb.getInstance().createAuthor(author);
    }

    @Override
    public Author read(int id){
        return BookShelfDb.getInstance().readAuthor(id);
    }

    @Override
    public MyArrayListImpl<Author> findAll(){
        return BookShelfDb.getInstance().readAllAuthors();
    }

    @Override
    public void update(Author author){
        BookShelfDb.getInstance().updateAuthor(author);
    }

    @Override
    public void delete(int id){
        BookShelfDb.getInstance().deleteAuthor(id);
    }
}
