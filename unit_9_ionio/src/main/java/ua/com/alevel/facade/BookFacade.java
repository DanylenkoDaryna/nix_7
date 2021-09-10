package ua.com.alevel.facade;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.service.BookService;

public class BookFacade implements Facade{

    private final BookService bookService = ObjectFactory.getInstance().getImplClass(BookService.class);

    public BookFacade(){
        System.out.println("BookFacade created!");
    }

    public void register(String title, MyArrayListImpl<Author> authorsIdList, String publisher, int pages){
        Book book = new Book();
        book.setTitle(title);
        book.setAuthors(authorsIdList);
        book.setPublisher(publisher);
        book.setPages(pages);
        bookService.create(book);
    }

    public void update(long id, String title, String publisher, int pages){
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setPages(pages);
        bookService.update(book);
    }
}
