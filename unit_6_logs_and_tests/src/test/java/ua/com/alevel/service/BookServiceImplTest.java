package ua.com.alevel.service;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.GenerateForTestsUtil;
import ua.com.alevel.db.BookShelfDb;
import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Book;


 class BookServiceImplTest{

    private static BookShelfDb bookShelfDB = BookShelfDb.getInstance();
    private static MyArrayListImpl<Book> bookShelf = new MyArrayListImpl<>();
    private static final int BOOKSHELF_SIZE = 10;
    private static BookService bookService= new BookServiceImpl();
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");


    @BeforeAll
     static void makeBooks(){
        System.out.println("Before");
        for (int i = 0; i < BOOKSHELF_SIZE; i++) {
            Book book = GenerateForTestsUtil.generateBook(i);
            bookShelf.add(book);
            bookService.create((Book)bookShelf.get(i));
        }
   }

    @AfterAll
     static void tearDown(){
        System.out.println("After");
        bookShelf.clear();
        bookShelfDB.getBookShelf().clear();
    }

    @Test
    @Order(1)
     void checkAllBooks(){
        LOGGER_INFO.info("test 1");
        System.out.println("test 1");
        bookShelf = bookService.findAll();
        Book bookFromTestBookshelf = (Book)bookShelf.get(1);
        Book bookFromDb = (Book)bookShelfDB.getBookShelf().get(1);
        assert(bookFromTestBookshelf.getId() == bookFromDb.getId());
    }

    @Test
    @Order(2)
     void checkBookRead(){
        System.out.println("test 2");
        int id = ((Book) bookService.findAll().get(0)).getId();
        Book book = bookService.read(id);
        assert(book.getTitle().equals("Poems. Part 0"));
    }

    @Test
    @Order(3)
     void checkBookUpdate(){
        System.out.println("test 3");
        Book book = (Book) bookService.findAll().get(5);
        int id = book.getId();
        book.setPages(200);
        bookService.update(book);
        Book updatedBook = bookService.read(id);
        assert(updatedBook.getPages() == 200);
    }

    @Test
    @Order(4)
     void checkBookDelete(){
        System.out.println("test 4");

        Book book = (Book) bookService.findAll().get(6);
        int id = book.getId();
        bookService.delete(id);
        MyArrayListImpl<Book> books = bookService.findAll();
        assert(books.size()==9);
    }
}