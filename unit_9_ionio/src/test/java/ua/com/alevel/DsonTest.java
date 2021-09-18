package ua.com.alevel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DsonTest{

    private static Dson dson;
    private static List<Book> books = new ArrayList<>();
    private static List<Author> authors = new ArrayList<>();
    private static final String ONE_OBJECT = "";
    private static final int CATALOGUE_SIZE = 10;
    private static final String PATH_TO_BOOKS_FILE = "unit_9_ionio\\test_books.json";
    private static final String PATH_TO_AUTHORS_FILE = "unit_9_ionio\\test_authors.json";

    @BeforeAll
    static void makeBooks(){
        Book book = GenerateForTestsUtil.generateBook(0);
        book.setId(GenerateForTestsUtil.generateFirstId());
        books.add(book);
        for(int i = 1; i < CATALOGUE_SIZE; i++){
            Book tempBook = GenerateForTestsUtil.generateBook(0);
            book.setId(GenerateForTestsUtil.generateNotFirstBookId(books));
            books.add(tempBook);
        }
    }

    @BeforeAll
    static void createFiles(){
        GenerateForTestsUtil.createFileIfNotExists(PATH_TO_BOOKS_FILE);
        GenerateForTestsUtil.createFileIfNotExists(PATH_TO_AUTHORS_FILE);
    }

    @BeforeAll
    static void makeAuthors(){
        Author author = GenerateForTestsUtil.generateAuthor(0);
        author.setId(GenerateForTestsUtil.generateFirstId());
        authors.add(author);
        for(int i = 1; i < CATALOGUE_SIZE; i++){
            Author tempAuthor = GenerateForTestsUtil.generateAuthor(i);
            tempAuthor.setId(GenerateForTestsUtil.generateNotFirstAuthorId(authors));
            authors.add(tempAuthor);
        }
    }

    @BeforeAll
    static void makeDson(){
        dson = new Dson();
    }

    @AfterAll
    static void cleanBooks(){
        books.clear();
    }

    @AfterAll
    static void cleanAuthors(){
        authors.clear();
    }

    @Test
    void test1(){
        System.out.println(books.toString());
        System.out.println();
    }

    @Test
    void jacksonObjectTest() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        String str = "{\"fullName\":\"Dsfd Sss\",\"id\":40}";
        Author author = objectMapper.readValue(str, Author.class);
        System.out.println(author.toString());
    }

    @Test
    void jacksonListTest() throws IOException{
        String str = "[{\"fullName\":\"Fred Wisley\",\"id\":40},{\"fullName\":\"Gorge Wisley\",\"id\":45}]";
        ObjectMapper objectMapper = new ObjectMapper();
        List<Author> authors = objectMapper.readValue(str, new TypeReference<List<Author>>(){
        });
        System.out.println(authors);
    }

    @Test
    void csvObjectTest() throws IOException{
        String str = "[{\"fullName\":\"Fred Wisley\",\"id\":40},{\"fullName\":\"Gorge Wisley\",\"id\":45}]";
        ObjectMapper objectMapper = new ObjectMapper();
        List<Author> authors = objectMapper.readValue(str, new TypeReference<List<Author>>(){
        });
        System.out.println(authors);
    }

    @Test
    void csvListTest() throws IOException{
        String str = "[{\"fullName\":\"Fred Wisley\",\"id\":40},{\"fullName\":\"Gorge Wisley\",\"id\":45}]";
        ObjectMapper objectMapper = new ObjectMapper();
        List<Author> authors = objectMapper.readValue(str, new TypeReference<List<Author>>(){
        });
        System.out.println(authors);
    }

    @Test
    void parseJson() throws IOException{
        String str = "{\"fullName\":\"Fred Wisley\",\"id\":40}";
        JsonElement jsonElement = new Gson().fromJson(str, JsonObject.class);
        if(jsonElement instanceof JsonObject){
            System.out.println("we have object");
            JsonObject obj = jsonElement.getAsJsonObject();
            System.out.println("Object = " + obj);
            String field = obj.get("fullName").getAsString();
            System.out.println("field = " + field);
            JsonObject jsonObj = jsonElement.getAsJsonObject();
            System.out.println("fields:");
            for(String s : jsonObj.keySet()){
                System.out.println(s);
            }
            System.out.println("entries:");
            for(Map.Entry<String, JsonElement> entry : jsonObj.entrySet()){
                System.out.println(entry);
                JsonElement value = entry.getValue();
                if(value.isJsonPrimitive()){
                    String primitive = value.getAsString();
                    if(str.matches("\\d+")){
                        Long aLong = Long.parseLong(primitive);
                    }
                }
                if(value.isJsonObject()){

                }
                if(value.isJsonArray()){

                }
            }
        }else if(jsonElement instanceof JsonArray){
            System.out.println("we have array");
        }
    }

    @Test
    void convertAuthorToDsonTest(){
        System.out.println();
        Author author = new Author("Lady Di");
        author.setId(23);
        System.out.println(dson.convertToJson(author));
    }

    @Test
    void convertBookToDsonTest(){
        System.out.println();
        System.out.println(dson.convertToJson(books.get(0)));
    }

    @Test
    void convertAuthorsToDsonTest(){
        System.out.println();
        System.out.println(dson.convertToJson(authors));
    }

    @Test
    void convertBooksToDsonTest(){
        System.out.println();
        System.out.println(dson.convertToJson(books));
    }

    @Test
    void convertAuthorFromDsonTest(){
        System.out.println();
        Author author = new Author("Lady Di");
        author.setId(23);
        String dsonObj = dson.convertToJson(author);
        System.out.println(dsonObj);
        Author author1 = (Author) dson.parseObjectFromJson(dsonObj, Author.class);
        System.out.println();
        System.out.println();
        System.out.println(author1.toString());
    }

    @Test
    void convertBookFromDsonTest(){
        System.out.println();
        String dsonObj = dson.convertToJson(books.get(0));
        System.out.println(dsonObj);
        Book book1 = (Book) dson.parseObjectFromJson(dsonObj, Book.class);
        System.out.println();
        System.out.println();
        System.out.println(book1.toString());
    }

    @Test
    void convertAuthorsFromDsonTest(){
        System.out.println();
        String dsonObj = dson.convertToJson(authors);
        System.out.println(dsonObj);
        List<Author> localAuthors = (ArrayList<Author>) dson.parseListFromJson(dsonObj, ArrayList.class, Author.class);
        System.out.println();
        System.out.println();
        System.out.println(localAuthors.toString());
    }

    @Test
    void convertBooksFromDsonTest(){
        System.out.println();
        String dsonObj = dson.convertToJson(books);
        System.out.println(dsonObj);
        System.out.println();
        System.out.println();
        List<Book> books = (ArrayList<Book>) dson.parseListFromJson(dsonObj, ArrayList.class, Book.class);
        System.out.println(books.toString());
    }
}
