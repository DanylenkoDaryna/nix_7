package ua.com.alevel.entity;

public class TableElement<T>{

    private int cellNum;
    private T value;

    public int getCellNum(){
        return cellNum;
    }

    public void setCellNum(int cellNum){
        this.cellNum = cellNum;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }
}
