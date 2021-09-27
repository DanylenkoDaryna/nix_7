package ua.com.alevel.entity;

public class Problem extends Entity{

    private int fromId;
    private int toId;

    public Problem(){
    }

    public Problem(int fromId, int toId){
        this.fromId = fromId;
        this.toId = toId;
    }

    public int getFromId(){
        return fromId;
    }

    public void setFromId(int fromId){
        this.fromId = fromId;
    }

    public int getToId(){
        return toId;
    }

    public void setToId(int toId){
        this.toId = toId;
    }
}
