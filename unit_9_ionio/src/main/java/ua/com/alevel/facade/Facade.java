package ua.com.alevel.facade;

import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;
import ua.com.alevel.service.BookService;

public interface Facade{

    void register(String title, MyArrayListImpl<Author> authorsIdList, String publisher, int pages);

    void update(long id, String title, String publisher, int pages);
}
