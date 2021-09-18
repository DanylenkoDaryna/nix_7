package ua.com.alevel.dao;

import ua.com.alevel.db.MyJsonConverterFileDb;
import ua.com.alevel.entity.Author;

import java.util.List;

public class AuthorDaoDsonImpl implements AuthorDao{

    private static MyJsonConverterFileDb fileDb;

    private static MyJsonConverterFileDb getInstance(){
        if(fileDb == null){
            fileDb = new MyJsonConverterFileDb();
        }
        return fileDb;
    }

    @Override
    public void create(Author author){
        getInstance().saveAuthor(author);
    }

    @Override
    public Author read(long id){
        return getInstance().findAuthor(id);
    }

    @Override
    public List<Author> findAll(){
        return getInstance().findAllAuthors();
    }

    @Override
    public void update(Author author){
        getInstance().updateAuthor(author);
    }

    @Override
    public void delete(long id){
        getInstance().deleteAuthor(id);
    }
}
