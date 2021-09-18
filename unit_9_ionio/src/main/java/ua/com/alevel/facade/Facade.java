package ua.com.alevel.facade;

import ua.com.alevel.entity.Author;

import java.util.List;

public interface Facade{

    void register(String title, List<Author> authors, String publisher, int pages);

    void update(long id, String title, List<Author> authors, String publisher, int pages);
}
