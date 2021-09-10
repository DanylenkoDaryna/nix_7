package ua.com.alevel.dao;

import ua.com.alevel.db.FileDb;
import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;

public class AuthorDaoFileImpl implements AuthorDao{

//    private static final FileDb fileDb = new FileDb();
//
//    public static FileDb getFileDb(){
//        return fileDb;
//    }

    public AuthorDaoFileImpl(){
        System.out.println("Dao.AuthorDaoFileImpl");
    }

    @Override
    public void create(Author author){
        new FileDb().saveAuthor(author);
    }

    @Override
    public Author read(long id){
        return new FileDb().findAuthor(id);
    }

    @Override
    public MyArrayListImpl<Author> findAll(){
        return new FileDb().findAllAuthors();
    }

    @Override
    public void update(Author author){
        //todo
        new FileDb().saveAuthor(author);
        new FileDb().updateAuthor(author);
    }

    @Override
    public void delete(long id){
        new FileDb().deleteAuthor(id);
    }
}
