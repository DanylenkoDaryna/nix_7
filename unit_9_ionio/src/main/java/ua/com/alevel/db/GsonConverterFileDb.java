package ua.com.alevel.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.entity.Entity;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GsonConverterFileDb{

    private static final String PATH_TO_BOOKS_FILE = "unit_9_ionio\\books.json";
    private static final String PATH_TO_AUTHORS_FILE = "unit_9_ionio\\authors.json";
    private static final Logger LOGGER_ERR = LoggerFactory.getLogger("error");

    public GsonConverterFileDb(){
        System.out.println("FileDb created...");
    }

    public void saveBook(Book book){
        System.out.println("saving book...");
        createFilesIfNotExist();
        Gson gson = new Gson();
        String jsonString;
        ArrayList<Book> list = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_BOOKS_FILE))){
            File file = new File(PATH_TO_BOOKS_FILE);
            if(file.length() == 0){
                book.setId(generateFirstId());
                list.add(book);
                jsonString = gson.toJson(list);
            }else{
                String line = bufferedReader.readLine();
                ArrayList<Book> tempList = getBookListFromFile(line, gson);
                book.setId(generateNotFirstId(tempList));
                tempList.add(book);
                jsonString = gson.toJson(tempList);
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

    private ArrayList<Book> getBookListFromFile(String fileInLine, Gson gson){
        Type ourListType = new TypeToken<ArrayList<Book>>(){
        }.getType();
        return gson.fromJson(fileInLine, ourListType);
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
        System.out.println("reading file...");
        Gson gson = new Gson();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_BOOKS_FILE))){
            File file = new File(PATH_TO_BOOKS_FILE);
            if(file.length() == 0){
                LOGGER_ERR.error("books.json is empty!!");
                System.out.println("There is no books here yet");
                return new Book();
            }else{
                String line = bufferedReader.readLine();
                ArrayList<Book> tempList = getBookListFromFile(line, gson);
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
        Gson gson = new Gson();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_BOOKS_FILE))){
            String line = bufferedReader.readLine();
            return getBookListFromFile(line, gson);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println("Bebeebebebe" + e.getMessage());
            return new ArrayList<>();
        }catch(NullPointerException ne){
            LOGGER_ERR.error(ne.getMessage());
            return new ArrayList<>();
        }
    }

    public void updateBook(Book book){
        System.out.println("updating file...");
        Gson gson = new Gson();
        String jsonString;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_BOOKS_FILE))){
            String line = bufferedReader.readLine();
            ArrayList<Book> tempList = getBookListFromFile(line, gson);
            for(Book tempBook : tempList){
                if(tempBook.getId() == book.getId()){
                    tempBook.setTitle(book.getTitle());
                    tempBook.setAuthors(book.getAuthors());
                    tempBook.setPublisher(book.getPublisher());
                    tempBook.setPages(book.getPages());
                }
            }
            // tempList.stream().filter(tempBook -> tempBook.getId()==book.getId()).findAny().get().setTitle(book.getTitle());
            jsonString = gson.toJson(tempList);
            writeInFile(jsonString, PATH_TO_BOOKS_FILE);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public void deleteBook(long id){
        System.out.println("deleting from file...");
        Gson gson = new Gson();
        String jsonString;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_BOOKS_FILE))){
            String line = bufferedReader.readLine();
            ArrayList<Book> tempList = getBookListFromFile(line, gson);
            tempList.removeIf(temp -> temp.getId() == id);
            jsonString = gson.toJson(tempList);
            writeInFile(jsonString, PATH_TO_BOOKS_FILE);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public void saveAuthor(Author author){
        System.out.println("saving author...");
        createFilesIfNotExist();
        Gson gson = new Gson();
        String jsonString;
        ArrayList<Author> list = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_AUTHORS_FILE))){
            File file = new File(PATH_TO_AUTHORS_FILE);
            if(file.length() == 0){
                author.setId(generateFirstId());
                list.add(author);
                jsonString = gson.toJson(list);
            }else{
                String line = bufferedReader.readLine();
                ArrayList<Author> tempList = getAuthorsListFromFile(line, gson);
                author.setId(generateNotFirstAuthorId(tempList));
                tempList.add(author);
                jsonString = gson.toJson(tempList);
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

    private ArrayList<Author> getAuthorsListFromFile(String fileInLine, Gson gson){
        Type ourListType = new TypeToken<ArrayList<Author>>(){
        }.getType();
        ArrayList<Author> tempList = gson.fromJson(fileInLine, ourListType);
        return tempList;
    }

    public Author findAuthor(long id){
        System.out.println("reading author...");
        Gson gson = new Gson();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_AUTHORS_FILE))){
            String line = bufferedReader.readLine();
            ArrayList<Author> tempList = getAuthorsListFromFile(line, gson);
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
        Gson gson = new Gson();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_AUTHORS_FILE))){
            String line = bufferedReader.readLine();
            return getAuthorsListFromFile(line, gson);
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
        Gson gson = new Gson();
        String jsonString;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_AUTHORS_FILE))){
            String line = bufferedReader.readLine();
            ArrayList<Author> tempList = getAuthorsListFromFile(line, gson);
            for(Author tempAuthor : tempList){
                if(tempAuthor.getId() == author.getId()){
                    tempAuthor.setId(author.getId());
                    tempAuthor.setFullName(author.getFullName());
                }
            }
            jsonString = gson.toJson(tempList);
            writeInFile(jsonString, PATH_TO_AUTHORS_FILE);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public void deleteAuthor(long id){
        System.out.println("deleting author from file...");
        Gson gson = new Gson();
        String jsonString;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_AUTHORS_FILE))){
            String line = bufferedReader.readLine();
            ArrayList<Author> tempList = getAuthorsListFromFile(line, gson);
            tempList.removeIf(temp -> temp.getId() == id);
            jsonString = gson.toJson(tempList);
            writeInFile(jsonString, PATH_TO_AUTHORS_FILE);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
