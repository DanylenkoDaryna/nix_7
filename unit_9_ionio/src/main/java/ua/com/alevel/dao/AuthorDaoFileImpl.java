package ua.com.alevel.dao;

import ua.com.alevel.db.GsonConverterFileDb;
import ua.com.alevel.entity.Author;

import java.util.List;

public class AuthorDaoFileImpl
//        implements AuthorDao
{

    private static GsonConverterFileDb fileDb;

    private static GsonConverterFileDb getInstance(){
        if(fileDb == null){
            fileDb = new GsonConverterFileDb();
        }
        return fileDb;
    }

    public AuthorDaoFileImpl(){
        System.out.println("Dao.AuthorDaoFileImpl");
    }

    //    @Override
    public void create(Author author){
        getInstance().saveAuthor(author);
    }

    //    @Override
    public Author read(long id){
        return getInstance().findAuthor(id);
    }

    //    @Override
    public List<Author> findAll(){
        return getInstance().findAllAuthors();
    }

    //    @Override
    public void update(Author author){
        //todo
        //new FileDb().saveAuthor(author);
        getInstance().updateAuthor(author);
    }

    //    @Override
    public void delete(long id){
        getInstance().deleteAuthor(id);
    }
}
