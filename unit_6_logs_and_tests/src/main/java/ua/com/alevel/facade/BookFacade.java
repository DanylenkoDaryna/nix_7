package ua.com.alevel.facade;

import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.service.BookService;
import ua.com.alevel.service.BookServiceImpl;


public class BookFacade{

    private final BookService bookService = new BookServiceImpl();

    public void register(String title, MyArrayListImpl<Author> authorsIdList, String publisher, int pages){
        Book book = new Book();
        book.setTitle(title);
        book.setAuthors(authorsIdList);
        book.setPublisher(publisher);
        book.setPages(pages);
        bookService.create(book);
    }

    public void update(int id, String title, String publisher, int pages){
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setPages(pages);
        bookService.update(book);
    }
}
