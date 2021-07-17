package ua.com.alevel;

import ua.com.alevel.task.Task;

public class Developer{

    String name;
    int workhours;
    Task task;

    public Developer(String dev_name, int dev_hours, Task dev_task){
        name=dev_name;
        workhours=dev_hours;
        task=dev_task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkhours() {
        return workhours;
    }

    public void setWorkhours(int workhours) {
        this.workhours = workhours;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", workhours=" + workhours +
                ", task=" + task +
                '}';
    }
}