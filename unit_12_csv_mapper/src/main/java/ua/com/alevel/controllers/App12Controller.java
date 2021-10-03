package ua.com.alevel.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.CsvTable;
import ua.com.alevel.entity.UserDetails;
import ua.com.alevel.service.CsvService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class App12Controller{

    private static final Logger LOGGER = LoggerFactory.getLogger(App12Controller.class);
    private final CsvService service = new CsvService();

    public void start(String pathToFile){
        List<String[]> csvRows = service.getListOfRows(pathToFile);
        service.showRows(csvRows);
        showMenu(csvRows);
    }

    private void showMenu(List<String[]> csvRows){
        CsvTable csvTable = service.getParsedTable(csvRows);
        boolean menuCycleBreaker = true;
        while(menuCycleBreaker){
            System.out.println("Choose an option:");
            System.out.println("1 - to get element by row number and column number");
            System.out.println("2 - to get element by row number and column name");
            System.out.println("3 - to get list of columns");
            System.out.println("4 - to get list of mapped UserDetails");
            String input = getUsersPreEditedCommand();
            switch(input){
                case "0":
                    menuCycleBreaker = false;
                    break;
                case "1":
                    getElementByRowNumColNum(csvTable);
                    break;
                case "2":
                    getElementByRowNumColName(csvTable);
                    break;
                case "3":
                    getHeaders(csvTable);
                    break;
                case "4":
                    getObjects(csvTable);
                    break;
                default:
                    System.out.println("Incorrect input! Please, try again");
            }
        }
    }

    private void getObjects(CsvTable csvTable){
        List<UserDetails> userDetails = service.getListOfObjects(csvTable, UserDetails.class);
        System.out.println(userDetails.toString());
    }

    private void getHeaders(CsvTable csvTable){
        System.out.println(Arrays.toString(csvTable.getHeaders().keySet().toArray()));
        System.out.println();
    }

    private void getElementByRowNumColName(CsvTable csvTable){
        int rowNum = getRowFromUser(csvTable);
        String colName = getColNameFromUser(csvTable);
        if(rowNum != -1){
            System.out.println("Chosen element = " + csvTable.get(rowNum, colName));
        }else{
            LOGGER.error("Can`t get your input correctly. Please, try again..");
            getElementByRowNumColName(csvTable);
        }
    }

    private String getColNameFromUser(CsvTable csvTable){
        System.out.println("Please, enter name of column title");
        String colName = getUsersPreEditedInput();
        if(isColNameMatchesRules(colName, csvTable)){
            return colName;
        }else{
            LOGGER.error("Incorrect name of column number, try again...");
            return getColNameFromUser(csvTable);
        }
    }

    private boolean isColNameMatchesRules(String colName, CsvTable csvTable){
        return !colName.matches("^[0-9]+$") & csvTable.getHeaders().containsKey(colName);
    }

    private void getElementByRowNumColNum(CsvTable csvTable){
        int rowNum = getRowFromUser(csvTable);
        int colNum = getColFromUser(csvTable);
        if(rowNum != -1 & colNum != -1){
            System.out.println("Chosen element = " + csvTable.get(rowNum, colNum));
        }else{
            LOGGER.error("Can`t get your input correctly. Please, try again..");
            getElementByRowNumColNum(csvTable);
        }
    }

    private int getColFromUser(CsvTable csvTable){
        System.out.println("Please, enter number of column from 0");
        int colNum = -1;
        String col = getUsersPreEditedInput();
        if(isColMatchesRules(col, csvTable)){
            colNum = Integer.parseInt(col);
        }else{
            LOGGER.error("Incorrect column number, try again...");
            getColFromUser(csvTable);
        }
        return colNum;
    }

    private int getRowFromUser(CsvTable csvTable){
        System.out.println("Please, enter number of row from 0");
        int rowNum = -1;
        String row = getUsersPreEditedInput();
        if(isRowMatchesRules(row, csvTable)){
            rowNum = Integer.parseInt(row);
        }else{
            LOGGER.error("Incorrect row number, try again...");
            getRowFromUser(csvTable);
        }
        return rowNum;
    }

    private boolean isColMatchesRules(String col, CsvTable csvTable){
        return col.matches("^[0-9]{1,3}$") & Integer.parseInt(col) <= csvTable.getHeaders().size()
                & Integer.parseInt(col) >= 0;
    }

    private boolean isRowMatchesRules(String row, CsvTable csvTable){
        return row.matches("^[0-9]{1,3}$") & Integer.parseInt(row) <= csvTable.getRows().size()
                & Integer.parseInt(row) >= 0;

    }

    private static BufferedReader getReader(){
        BufferedReader mainReader = null;
        try{
            mainReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        }catch(UnsupportedEncodingException e){
            LOGGER.error(e.getMessage());
        }
        return mainReader;
    }

    private static String getUsersPreEditedCommand(){
        try{
            return getReader().readLine().trim().toLowerCase().replaceAll(" ", "");
        }catch(NullPointerException ne){
            LOGGER.error("method getReader() returned null");
            return getUsersPreEditedCommand();
        }catch(IOException e){
            LOGGER.error("Can`t read from input");
            return getUsersPreEditedCommand();
        }
    }

    private static String getUsersPreEditedInput(){
        try{
            return getReader().readLine().trim();
        }catch(IOException e){
            LOGGER.error("Can`t read from input");
            return getUsersPreEditedInput();
        }
    }
}