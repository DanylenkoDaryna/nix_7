package ua.com.alevel.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvTable{

    private Map<String, Integer> headers;
    private Map<Integer, List<String>> rows;

    public CsvTable(){
        headers = new HashMap<>();
        rows = new HashMap<>();
    }

    public CsvTable(int sizeRows, int sizeColumns){
        headers = new HashMap<>(sizeColumns);
        rows = new HashMap<>(sizeRows);
    }

    public Map<String, Integer> getHeaders(){
        return headers;
    }

    public void setHeaders(Map<String, Integer> headers){
        this.headers = headers;
    }

    public Map<Integer, List<String>> getRows(){
        return rows;
    }

    public void setRows(Map<Integer, List<String>> rows){
        this.rows = rows;
    }

    public String get(int row, String columnName){

        int column = getHeaders().get(columnName);
        return getRows().get(row).get(column);
    }

    public String get(int row, int column){
        return getRows().get(row).get(column);
    }
}
