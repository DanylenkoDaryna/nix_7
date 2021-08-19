package ua.com.alevel.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.GenerateForTestsUtil;
import ua.com.alevel.db.BookShelfDb;
import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;


class AuthorServiceImplTest{

    private static BookShelfDb bookShelfDB = BookShelfDb.getInstance();
    private static final int AUTHOR_CATALOGUE_SIZE = 10;
    private static MyArrayListImpl<Author> authorCatalogue = new MyArrayListImpl<>();
    private static AuthorService authorService = new AuthorServiceImpl();
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");

    @BeforeAll
    static void makeAuthors(){
        System.out.println("Before");
        for(int i = 0; i < AUTHOR_CATALOGUE_SIZE; i++){
            Author author = GenerateForTestsUtil.generateAuthor(i);
            authorCatalogue.add(author);
            authorService.create((Author) authorCatalogue.get(i));
        }
    }

    @AfterAll
    static void cleanAuthors(){
        System.out.println("After");
        authorCatalogue.clear();
        bookShelfDB.getAuthorCatalogue().clear();
    }

    @Test
    @Order(1)
    void checkAllAuthors(){
        LOGGER_INFO.info("test 1");
        System.out.println("test 1");
        authorCatalogue = authorService.findAll();
        Author testAuthor = (Author) authorCatalogue.get(1);
        Author catalogueAuthor = (Author) bookShelfDB.getAuthorCatalogue().get(1);
        assert (testAuthor.getId() == catalogueAuthor.getId());
    }

    @Test
    @Order(2)
    public void checkAuthorRead(){
        System.out.println("test 2");
        int id = ((Author) authorService.findAll().get(1)).getId();
        Author catalogueAuthor = authorService.read(id);
        assert (catalogueAuthor.getFullName().equals("Taras Shevchenko The 1th"));
    }

    @Test
    @Order(3)
    void checkAuthorUpdate(){
        System.out.println("test 3");
        Author catalogueAuthor = (Author) authorService.findAll().get(5);
        int id = catalogueAuthor.getId();
        catalogueAuthor.setFullName("Panteleimon Kulish");
        authorService.update(catalogueAuthor);
        Author updatedAuthor = authorService.read(id);
        assert (updatedAuthor.getFullName().equals("Panteleimon Kulish"));
    }

    @Test
    @Order(4)
    void checkAuthorDelete(){
        System.out.println("test 4");

        Author catalogueAuthor = (Author) authorService.findAll().get(6);
        int id = catalogueAuthor.getId();
        authorService.delete(id);
        MyArrayListImpl<Author> authors = authorService.findAll();
        assert (authors.size() == 9);
    }
}