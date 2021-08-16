package ua.com.alevel.service;

import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.AuthorDaoImpl;
import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;

public class AuthorServiceImpl implements AuthorService{

    private static final AuthorDao authorDao = new AuthorDaoImpl();

    @Override
    public void create(Author author){
        authorDao.create(author);
    }

    @Override
    public Author read(int id){
        return authorDao.read(id);
    }

    @Override
    public MyArrayListImpl<Author> findAll(){
        return authorDao.findAll();
    }

    @Override
    public void update(Author author){
        authorDao.update(author);
    }

    @Override
    public void delete(int id){
        authorDao.delete(id);
    }
}
