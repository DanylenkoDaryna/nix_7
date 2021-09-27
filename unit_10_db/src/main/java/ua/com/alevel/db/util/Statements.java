package ua.com.alevel.db.util;

public class Statements{

    public static final String FIND_ALL_LOCATIONS = "SELECT * FROM unit10db.locations;";
    public static final String FIND_ALL_ROUTES = "select * from routes";
    public static final String FIND_ALL_PROBLEMS = "select * from problems";
    public static final String INSERT_NEW_SOLUTION = "insert into solutions(problem_id, cost) values(?,?)";

    private Statements(){
        System.out.println("This is util class!");
    }
}
