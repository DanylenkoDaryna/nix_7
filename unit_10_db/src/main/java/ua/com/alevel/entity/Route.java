package ua.com.alevel.entity;

public class Route extends Entity{

    private int fromId;
    private int toId;
    private int cost;

    public Route(){
    }

    public Route(int fromId, int toId, int cost){
        this.fromId = fromId;
        this.toId = toId;
        this.cost = cost;
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

    public int getCost(){
        return cost;
    }

    public void setCost(int cost){
        this.cost = cost;
    }
}
