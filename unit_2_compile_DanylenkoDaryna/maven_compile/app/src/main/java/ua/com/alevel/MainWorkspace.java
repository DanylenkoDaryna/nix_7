package ua.com.alevel;

import ua.com.alevel.task.Task;

public class MainWorkspace{

    public static void main(String[] args) {

        System.out.println("Start working with Maven...");

        Task task_1 = new Task(1,"Daily Meeting");
        Task task_2 = new Task(2,"Fix bugs");

        Developer developer1 = new Developer("Serhiy Sviridov", 3, task_1);
        Developer developer2 = new Developer("Lina Kostenko", 2, task_2);

        developer1.getTask().useJodaLibrary();
        developer1.getTask().useHirondelleDateLibrary();

        System.out.println("End working with Maven...");

    }
}