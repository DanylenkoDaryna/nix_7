package ua.com.alevel;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.CsvTable;
import ua.com.alevel.parser.CsvParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class ParserTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(ParserTest.class);
    private static final String PATH_TO_FILE = "unit_12_csv_mapper/files/input.csv";
    private static CsvTable csvTable;

    @BeforeAll
    static void makeBefore(){
        List<String[]> list = new ArrayList<>();
        try(Reader reader = Files.newBufferedReader(Paths.get(PATH_TO_FILE));
            CSVReader csvReader = new CSVReader(reader)){
            list = csvReader.readAll();
            CsvParser csvParser = new CsvParser();
            csvTable = csvParser.parse(list);
        }catch(IOException e){
            LOGGER.error("IOException in test", e);
        }catch(CsvException e){
            LOGGER.error("problems with parse file by csv lib", e);
        }
    }

    @AfterAll
    static void makeAfter(){
        csvTable.getHeaders().clear();
        csvTable.getRows().clear();
    }

    @Order(1)
    @Test
    void testGetByColumnName(){
        Assert.assertEquals("Anny", csvTable.get(1, "firstName"));
    }

    @Order(2)
    @Test
    void testGetByColumnNumber(){
        Assert.assertEquals("Anny", csvTable.get(1, 1));
    }

    @Order(3)
    @Test
    void testGetLastElement(){
        Assert.assertEquals("0.50", csvTable.get(4, "engagementScore"));
    }
}
