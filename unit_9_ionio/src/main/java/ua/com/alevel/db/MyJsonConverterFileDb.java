package ua.com.alevel.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.Dson;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.entity.Entity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyJsonConverterFileDb{

    //    private static final String PATH_TO_BOOKS_FILE = "books.json";
    private static final String PATH_TO_BOOKS_FILE = "books.json";
    //    private static final String PATH_TO_AUTHORS_FILE = "authors.json";
    private static final String PATH_TO_AUTHORS_FILE = "authors.json";
    private static final Logger LOGGER_ERR = LoggerFactory.getLogger("error");

    public MyJsonConverterFileDb(){
    }

    public void saveBook(Book book){
        System.out.println("saving book...");
        createFilesIfNotExist();
        Dson dson = new Dson();
        String jsonString = "";
        List<Book> list = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_BOOKS_FILE))){
            File file = new File(PATH_TO_BOOKS_FILE);
            if(file.length() == 0){
                book.setId(generateFirstId());
                list.add(book);
                jsonString = dson.convertToJson(list);
            }else{
                String line = bufferedReader.readLine();
                ArrayList<Book> tempList = getBookListFromFile(line, dson);
                book.setId(generateNotFirstId(tempList));
                tempList.add(book);
                jsonString = dson.convertToJson(tempList);
            }
            writeInFile(jsonString, PATH_TO_BOOKS_FILE);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private long generateNotFirstId(List<Book> tempList){
        int id = new Random().nextInt(100);
        for(Entity tempEntity : tempList){
            if(tempEntity.getId() == id){
                return generateNotFirstId(tempList);
            }
        }
        return id;
    }

    private long generateFirstId(){
        return new Random().nextInt(100);
    }

    private ArrayList<Book> getBookListFromFile(String jsonFromFile, Dson dson){
        return (ArrayList<Book>) dson.parseListFromJson(jsonFromFile, ArrayList.class, Book.class);
    }

    private void writeInFile(String jsonString, String pathToFile){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile))){
            bufferedWriter.write(jsonString);
            bufferedWriter.flush();
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private void createFilesIfNotExist(){
        createFileIfNotExists(PATH_TO_BOOKS_FILE);
        createFileIfNotExists(PATH_TO_AUTHORS_FILE);
    }

    private static void createFileIfNotExists(String pathToFile){
        Path path = Paths.get(pathToFile);
        try{
            if(!Files.exists(path)){
                Files.createFile(path);
            }
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public Book findBook(long id){
        System.out.println("reading file...");
        Dson dson = new Dson();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_BOOKS_FILE))){
            File file = new File(PATH_TO_BOOKS_FILE);
            if(file.length() == 0){
                LOGGER_ERR.error("books.json is empty!!");
                System.out.println("There is no books here yet");
                return new Book();
            }else{
                String line = bufferedReader.readLine();
                ArrayList<Book> tempList = getBookListFromFile(line, dson);
                return tempList.stream().filter(book -> book.getId() == id).findAny().orElse(null);
            }
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
            return new Book();
        }catch(NullPointerException ne){
            LOGGER_ERR.error(ne.getMessage());
            return new Book();
        }
    }

    public List<Book> findAllBooks(){
        System.out.println("reading all file...");
        Dson dson = new Dson();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_BOOKS_FILE))){
            String line = bufferedReader.readLine();
            return getBookListFromFile(line, dson);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }catch(NullPointerException ne){
            LOGGER_ERR.error(ne.getMessage());
            return new ArrayList<>();
        }
    }

    public void updateBook(Book book){
        System.out.println("updating file...");
        Dson dson = new Dson();
        String jsonString;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_BOOKS_FILE))){
            String line = bufferedReader.readLine();
            ArrayList<Book> tempList = getBookListFromFile(line, dson);
            for(Book tempBook : tempList){
                if(tempBook.getId() == book.getId()){
                    tempBook.setTitle(book.getTitle());
                    tempBook.setAuthors(book.getAuthors());
                    tempBook.setPublisher(book.getPublisher());
                    tempBook.setPages(book.getPages());
                }
            }
            // tempList.stream().filter(tempBook -> tempBook.getId()==book.getId()).findAny().get().setTitle(book.getTitle());
            jsonString = dson.convertToJson(tempList);
            writeInFile(jsonString, PATH_TO_BOOKS_FILE);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public void deleteBook(long id){
        System.out.println("deleting from file...");
        Dson dson = new Dson();
        String jsonString;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_BOOKS_FILE))){
            String line = bufferedReader.readLine();
            ArrayList<Book> tempList = getBookListFromFile(line, dson);
            tempList.removeIf(temp -> temp.getId() == id);
            jsonString = dson.convertToJson(tempList);
            writeInFile(jsonString, PATH_TO_BOOKS_FILE);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public void saveAuthor(Author author){
        System.out.println("saving author...");
        createFilesIfNotExist();
        Dson dson = new Dson();
        String jsonString;
        ArrayList<Author> list = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_AUTHORS_FILE))){
            File file = new File(PATH_TO_AUTHORS_FILE);
            if(file.length() == 0){
                author.setId(generateFirstId());
                list.add(author);
                jsonString = dson.convertToJson(list);
            }else{
                String line = bufferedReader.readLine();
                ArrayList<Author> tempList = getAuthorsListFromFile(line, dson);
                author.setId(generateNotFirstAuthorId(tempList));
                tempList.add(author);
                jsonString = dson.convertToJson(tempList);
            }
            writeInFile(jsonString, PATH_TO_AUTHORS_FILE);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private long generateNotFirstAuthorId(List<Author> tempList){
        int id = new Random().nextInt(100);
        for(Entity tempEntity : tempList){
            if(tempEntity.getId() == id){
                return generateNotFirstAuthorId(tempList);
            }
        }
        return id;
    }

    private ArrayList<Author> getAuthorsListFromFile(String jsonFromFile, Dson dson){
        ArrayList<Author> tempList = (ArrayList<Author>) dson.parseListFromJson(jsonFromFile, ArrayList.class, Author.class);
        return tempList;
    }

    public Author findAuthor(long id){
        System.out.println("reading author...");
        Dson dson = new Dson();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_AUTHORS_FILE))){
            String line = bufferedReader.readLine();
            ArrayList<Author> tempList = getAuthorsListFromFile(line, dson);
            return tempList.stream().filter(author -> author.getId() == id).findAny().orElse(new Author());
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
            return new Author();
        }catch(NullPointerException ne){
            LOGGER_ERR.error(ne.getMessage());
            return new Author();
        }
    }

    public List<Author> findAllAuthors(){
        System.out.println("reading all authors...");
        Dson dson = new Dson();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_AUTHORS_FILE))){
            String line = bufferedReader.readLine();
            return getAuthorsListFromFile(line, dson);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }catch(NullPointerException ne){
            LOGGER_ERR.error(ne.getMessage());
            return new ArrayList<>();
        }
    }

    public void updateAuthor(Author author){
        System.out.println("updating authors file...");
        Dson dson = new Dson();
        String jsonString;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_AUTHORS_FILE))){
            String line = bufferedReader.readLine();
            ArrayList<Author> tempList = getAuthorsListFromFile(line, dson);
            for(Author tempAuthor : tempList){
                if(tempAuthor.getId() == author.getId()){
                    tempAuthor.setId(author.getId());
                    tempAuthor.setFullName(author.getFullName());
                }
            }
            jsonString = dson.convertToJson(tempList);
            writeInFile(jsonString, PATH_TO_AUTHORS_FILE);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public void deleteAuthor(long id){
        System.out.println("deleting author from file...");
        Dson dson = new Dson();
        String jsonString;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_AUTHORS_FILE))){
            String line = bufferedReader.readLine();
            ArrayList<Author> tempList = getAuthorsListFromFile(line, dson);
            tempList.removeIf(temp -> temp.getId() == id);
            jsonString = dson.convertToJson(tempList);
            writeInFile(jsonString, PATH_TO_AUTHORS_FILE);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
