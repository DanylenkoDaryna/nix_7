package ua.com.alevel;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.UserDetails;
import ua.com.alevel.mapper.CsvMapper;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainPractice1{

    private static final Logger LOGGER_ERR = LoggerFactory.getLogger("error");

    public static void main(String[] args){
        String pathToFile = args[0];
        findAllUserDetails(pathToFile);
    }

    public static void findAllUserDetails(String pathToFile){
        System.out.println("reading csv file...");
        List<String[]> list = new ArrayList<>();
        try(Reader reader = Files.newBufferedReader(Paths.get(pathToFile));
            CSVReader csvReader = new CSVReader(reader)){
            list = csvReader.readAll();
            getUserDetailsList(list);
        }catch(IOException e){
            LOGGER_ERR.error(e.getMessage());
            System.out.println(e.getMessage());
        }catch(CsvException ne){
            LOGGER_ERR.error(ne.getMessage());
        }
    }

    private static void getUserDetailsList(List<String[]> list){
        CsvMapper mapper = new CsvMapper();
        mapper.mapObjects(list, UserDetails.class);
        for(String[] strs : list){
            for(String str : strs){
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
