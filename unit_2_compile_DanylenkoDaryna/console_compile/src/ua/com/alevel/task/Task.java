package ua.com.alevel.task;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import hirondelle.date4j.DateTime;
import java.util.TimeZone;

public class Task{

    int task_id;
    String task_name;

    public Task(int id, String name){
        task_id=id;
        task_name=name;
    }

    public void useJodaLibrary() {
        DateTimeFormatter dateFormat = DateTimeFormat
                .forPattern("G,C,Y,x,w,e,E,Y,D,M,d,a,K,h,H,k,m,s,S,z,Z");
        System.out.println("using Joda Library fo something...");
    }

    public void useHirondelleDateLibrary() {
        DateTime allNow = DateTime.now(TimeZone.getDefault());

                System.out.println("using Hirondelle Date Library fo something...");
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", task_name='" + task_name + '\'' +
                '}';
    }
}