package ua.com.alevel.parser;

import ua.com.alevel.entity.CsvTable;

import java.util.Arrays;
import java.util.List;

public class CsvParser{

    public CsvTable parse(List<String[]> list){
        CsvTable csvTable = new CsvTable(list.size(), list.get(0).length);
        for(int i = 1; i < list.size(); i++){
            csvTable.getRows().put(i - 1, Arrays.asList(list.get(i)));
        }
        for(int j = 0; j < list.get(0).length; j++){
            csvTable.getHeaders().put(list.get(0)[j], j);
        }
        return csvTable;
    }
}
