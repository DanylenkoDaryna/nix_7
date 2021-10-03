package ua.com.alevel.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.CsvTable;
import ua.com.alevel.mapper.CsvMapper;
import ua.com.alevel.parser.CsvParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvService{

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvService.class);

    public List<String[]> getListOfRows(String pathToFile){
        LOGGER.info("reading csv file...");
        List<String[]> list = new ArrayList<>();
        try(Reader reader = Files.newBufferedReader(Paths.get(pathToFile));
            CSVReader csvReader = new CSVReader(reader)){
            list = csvReader.readAll();
        }catch(IOException e){
            LOGGER.error(e.getMessage());
            System.out.println(e.getMessage());
        }catch(CsvException ne){
            LOGGER.error(ne.getMessage());
        }
        return list;
    }


    public <T> List<T> getListOfObjects(CsvTable csvTable, Class<T> tClass){
        CsvMapper mapper = new CsvMapper();
        return mapper.map(csvTable, tClass);
    }

    public void showRows(List<String[]> list){
        for(String[] strings : list){
            for(String str : strings){
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    public CsvTable getParsedTable(List<String[]> list){
        CsvParser csvParser = new CsvParser();
        return csvParser.parse(list);
    }
}
