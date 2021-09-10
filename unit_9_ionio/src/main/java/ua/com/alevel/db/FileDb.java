package ua.com.alevel.db;

import ch.qos.logback.core.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileDb{

    private static final String PATH_TO_BOOKS_FILE = "unit_9_ionio\\books.json";
    private static final String PATH_TO_AUTHORS_FILE = "unit_9_ionio\\authors.json";
    private static final Logger LOGGER_ERR = LoggerFactory.getLogger("error");

//    private final FileDb instance = new FileDb();

    public FileDb(){
    }

    // public static FileDb getInstance(){
    //    return instance;
    //  }

    public void saveBook(Book book){
        System.out.println("creating files...");
//        createFile(PATH_TO_BOOKS_FILE);
//        createFile(PATH_TO_AUTHORS_FILE);
//        try(ObjectOutputStream oos = new ObjectOutputStream(
//                new FileOutputStream(PATH_TO_BOOKS_FILE))){
//            oos.writeObject(book);
//        }catch(FileNotFoundException e){
//            e.printStackTrace();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        readBook();

        /////////////////////////////////////////////
        Gson gson = new GsonBuilder().create();
        String p = gson.toJson(book);
        System.out.println("We put in file = " + p);
        BufferedWriter bufferedWriter = null;
        try{
            bufferedWriter = new BufferedWriter(new FileWriter(PATH_TO_BOOKS_FILE, true));
            bufferedWriter.write(p);
            bufferedWriter.flush();
            //Files.write(PATH_TO_BOOKS_FILE, p, StandardOpenOption.APPEND);
            BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_BOOKS_FILE));
            String out = reader.readLine();
            System.out.println("We get from file = " + out);
            Book book1 = gson.fromJson(out, Book.class);
            System.out.println("We get a book = " + book1.toString());
            //Book book2 = gson.fromJson(p, Book.class);
            //System.out.println(book2.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void readBook(){
        System.out.println("reading files...");
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream((PATH_TO_BOOKS_FILE)))){
            Book book = (Book) ois.readObject();
            System.out.println(book.toString());
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private void createFile(String pathToFile){
        Path path = Paths.get(pathToFile);
        try{
            boolean exists = Files.exists(path);
            if(!exists){
                Files.createFile(path);
            }
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private void deleteFile(String pathToFile){
        Path path = Paths.get(pathToFile);
        try{
            Files.deleteIfExists(path);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public Book findBook(long id){
        return new Book();
    }

    public MyArrayListImpl<Book> findAllBooks(){
        return new MyArrayListImpl<Book>();
    }

    public void updateBook(Book book){
    }

    public void deleteBook(long id){
    }

    public void saveAuthor(Author author){

    }

    public Author findAuthor(long id){

        return new Author();
    }

    public MyArrayListImpl<Author> findAllAuthors(){
        return new MyArrayListImpl<Author>();
    }

    public void updateAuthor(Author author){
    }

    public void deleteAuthor(long id){
    }
}
