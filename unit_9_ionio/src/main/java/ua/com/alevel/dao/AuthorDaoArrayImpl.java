package ua.com.alevel.dao;

import ua.com.alevel.db.BookShelfDb;
import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;

public class AuthorDaoArrayImpl implements AuthorDao{

    private AuthorDaoArrayImpl(){
        System.out.println("Dao.AuthorDaoArrayImpl");
    }

    @Override
    public void create(Author author){
        BookShelfDb.getInstance().createAuthor(author);
    }

    @Override
    public Author read(long id){
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
    public void delete(long id){
        BookShelfDb.getInstance().deleteAuthor(id);
    }
}
