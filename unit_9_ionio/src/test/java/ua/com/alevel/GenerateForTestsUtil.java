package ua.com.alevel;

import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.entity.Entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateForTestsUtil{

    private static final int ARRAY_SIZE = 2;

    public static Book generateBook(int index){

        Book book = new Book();
        book.setTitle("Poems. Part " + index);
        book.setAuthors(generateAuthors());
        book.setPublisher("A-ba-ba-ga-la-ma-ga");
        book.setPages(800);
        return book;
    }

    public static Author generateAuthor(int index){
        Author author = new Author();
        author.setFullName("Taras Shevchenko The " + index + "th");
        return author;
    }

    private static List<Author> generateAuthors(){
        ArrayList<Author> authors = new ArrayList<>();
        for(int i = 0; i < ARRAY_SIZE; i++){
            Author temp = generateAuthor(i);
            temp.setId(generateNotFirstAuthorId(authors));
            authors.add(temp);
        }
        return authors;
    }

    public static long generateNotFirstAuthorId(List<Author> tempList){
        int id = new Random().nextInt(100);
        for(Entity tempEntity : tempList){
            if(tempEntity.getId() == id){
                return generateNotFirstAuthorId(tempList);
            }
        }
        return id;
    }

    public static long generateNotFirstBookId(List<Book> tempList){
        int id = new Random().nextInt(100);
        for(Entity tempEntity : tempList){
            if(tempEntity.getId() == id){
                return generateNotFirstBookId(tempList);
            }
        }
        return id;
    }

    public static long generateFirstId(){
        return new Random().nextInt(100);
    }

    static void createFileIfNotExists(String pathToFile){
        Path path = Paths.get(pathToFile);
        try{
            if(!Files.exists(path)){
                Files.createFile(path);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
