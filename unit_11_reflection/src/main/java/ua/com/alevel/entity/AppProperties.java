package ua.com.alevel.entity;

import ua.com.alevel.Main11;
import ua.com.alevel.annotations.PropertyKey;

import java.util.Date;

public class AppProperties{

    @PropertyKey("jdbc.url")
    public String url;

    private String className;

    @PropertyKey("transaction.commit.auto")
    public boolean autoCommit;

    @PropertyKey("connections.limit")
    public int maxConnections;

    @PropertyKey("characterEncoding")
    public CharEncoding characterEncoding;

    @PropertyKey("responce.wait.mills")
    public long waitMillis;

    @PropertyKey("app.shop.price")
    public double price;

    @PropertyKey("connections.create.date")
    public Date date;

    public AppProperties(){
        className = Main11.class.getName();
    }

    @Override
    public String toString(){
        return "AppProperties{" +
                "url='" + url + '\'' +
                ", className='" + className + '\'' +
                ", autoCommit=" + autoCommit +
                ", maxConnections=" + maxConnections +
                ", characterEncoding=" + characterEncoding +
                ", waitMillis=" + waitMillis +
                ", price=" + price +
                ", date=" + date +
                '}';
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getClassName(){
        return className;
    }

    public void setClassName(String className){
        this.className = className;
    }

    public boolean isAutoCommit(){
        return autoCommit;
    }

    public void setAutoCommit(boolean autoCommit){
        this.autoCommit = autoCommit;
    }

    public int getMaxConnections(){
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections){
        this.maxConnections = maxConnections;
    }

    public CharEncoding getCharacterEncoding(){
        return characterEncoding;
    }

    public void setCharacterEncoding(CharEncoding characterEncoding){
        this.characterEncoding = characterEncoding;
    }

    public long getWaitMillis(){
        return waitMillis;
    }

    public void setWaitMillis(long waitMillis){
        this.waitMillis = waitMillis;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }
}
