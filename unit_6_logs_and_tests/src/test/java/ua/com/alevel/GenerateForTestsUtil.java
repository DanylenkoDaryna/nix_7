package ua.com.alevel;

import ua.com.alevel.db.MyArrayListImpl;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

public class GenerateForTestsUtil{

    public static Book generateBook(int index){

        Book book = new Book();
        book.setTitle("Poems. Part "+index);
        MyArrayListImpl<Author> authors = new MyArrayListImpl<>();
        authors.add(generateAuthor(index));
        book.setAuthors(authors);
        book.setPublisher("A-ba-ba-ga-la-ma-ga");
        book.setPages(800);
        return book;
    }

    public static Author generateAuthor(int index){
        Author author = new Author();
        author.setFullName("Taras Shevchenko The " + index + "th");
        return author;
    }
}
