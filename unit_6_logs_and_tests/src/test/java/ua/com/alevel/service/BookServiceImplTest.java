package ua.com.alevel.service;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Book;

import static org.junit.Assert.*;

public class BookServiceImplTest{

    BookService bookService = new BookServiceImpl();
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    @BeforeAll
    public void makeBook(){

        LOGGER_INFO.info("test");
        LOGGER_WARN.info("test");
//        Book book = BookGenerationUtil.generateBook("Taras Shevchenko", "Kateryna", "Vivat", 90);
//        bookService.create(book);
    }

    @Test
    public void create(){
    }

    @Test
    public void read(){
    }

    @Test
    public void update(){
    }

    @Test
    public void delete(){
    }
}