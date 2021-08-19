package ua.com.alevel.db;

import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

import java.util.Random;

public class BookShelfDb{

    private final MyArrayListImpl<Book> bookShelf = new MyArrayListImpl<>();
    private final MyArrayListImpl<Author> authorCatalogue = new MyArrayListImpl<>();

    private static BookShelfDb arrayListDb;

    private BookShelfDb(){
    }

    public static BookShelfDb getInstance(){
        if(arrayListDb == null){
            arrayListDb = new BookShelfDb();
        }
        return arrayListDb;
    }

    public void createBook(Book book){
        book.setId(generateBookId());
        MyArrayListImpl<Author> tempAuthors = book.getAuthors();
        for(int i = 0; i < tempAuthors.size(); i++){
            ((Author) tempAuthors.get(i)).setId(generateAuthorId());
            checkAndAddAuthor((Author) tempAuthors.get(i));
        }
        bookShelf.add(book);
    }

    public Book readBook(int idToFind){
        for(int i = 0; i < bookShelf.size(); i++){
            Book tempBook = (Book) bookShelf.get(i);
            if(tempBook.getId() == idToFind){
                return tempBook;
            }
        }
        System.out.println("No such book");
        return null;
    }

    public MyArrayListImpl<Book> readAllBooks(){
        return bookShelf;
    }

    public void updateBook(Book bookWithUpdateInfo){
        for(int i = 0; i < bookShelf.size(); i++){
            Book tempBook = (Book) bookShelf.get(i);
            if(tempBook.getId() == bookWithUpdateInfo.getId()){
                tempBook.setTitle(bookWithUpdateInfo.getTitle());
                tempBook.setPublisher(bookWithUpdateInfo.getPublisher());
                tempBook.setPages(bookWithUpdateInfo.getPages());
            }
        }
    }

    public void deleteBook(int idToDelete){
        for(int i = 0; i < bookShelf.size(); i++){
            if(((Book) bookShelf.get(i)).getId() == idToDelete){
                bookShelf.remove(i);
            }
        }
    }

    public void createAuthor(Author author){
        if(isAuthorAlreadyExisted(author)){
            System.out.println("This author already existed!");
        }else{
            author.setId(generateAuthorId());
            authorCatalogue.add(author);
        }
    }

    private void checkAndAddAuthor(Author newOne){
        if(isAuthorAlreadyExisted(newOne)){
            System.out.println("This author already existed!");
        }else{
            authorCatalogue.add(newOne);
        }
    }

    private boolean isAuthorAlreadyExisted(Author newOne){
        for(int i = 0; i < authorCatalogue.size(); i++){
            Author tempAuthor = (Author) authorCatalogue.get(i);
            if(tempAuthor.getFullName().equals(newOne.getFullName())){
                newOne.setId(tempAuthor.getId());
                return true;
            }
        }
        return false;
    }

    public Author readAuthor(int idToFind){
        for(int i = 0; i < authorCatalogue.size(); i++){
            Author tempAuthor = (Author) authorCatalogue.get(i);
            if(tempAuthor.getId() == idToFind){
                return tempAuthor;
            }
        }
        return null;
    }

    public MyArrayListImpl<Author> readAllAuthors(){
        return authorCatalogue;
    }

    public void updateAuthor(Author authorWithUpdateInfo){
        for(int i = 0; i < authorCatalogue.size(); i++){
            Author tempAuthor = (Author) authorCatalogue.get(i);
            if(tempAuthor.getId() == authorWithUpdateInfo.getId()){
                tempAuthor.setFullName(authorWithUpdateInfo.getFullName());
            }
        }
    }

    public void deleteAuthor(int idToDelete){
        for(int i = 0; i < authorCatalogue.size(); i++){
            Author tempAuthor = (Author) authorCatalogue.get(i);
            if(tempAuthor.getId() == idToDelete){
                authorCatalogue.remove(i);
            }
        }
    }

    private int generateBookId(){
        int id = new Random().nextInt(100);
        for(int i = 0; i < bookShelf.size(); i++){
            if(((Book) bookShelf.get(i)).getId() == id){
                return generateBookId();
            }
        }
        return id;
    }

    private int generateAuthorId(){
        int id = new Random().nextInt(100);
        for(int i = 0; i < authorCatalogue.size(); i++){
            if(((Author) authorCatalogue.get(i)).getId() == id){
                return generateAuthorId();
            }
        }
        return id;
    }

    public MyArrayListImpl<Book> getBookShelf(){
        return bookShelf;
    }

    public MyArrayListImpl<Author> getAuthorCatalogue(){
        return authorCatalogue;
    }
}