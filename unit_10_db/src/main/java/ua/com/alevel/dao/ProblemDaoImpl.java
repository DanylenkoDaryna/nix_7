package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Problem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProblemDaoImpl implements ProblemDao{
    private static final Logger LOGGER = LoggerFactory.getLogger(ProblemDaoImpl.class);
    private static final String FIND_ALL_UNSOLVED_PROBLEMS = "SELECT * FROM problems " +
            "left join solutions on problems.id = solutions.problem_id\n" +
            "where solutions.problem_id is null";
    private Connection connection;

    public ProblemDaoImpl(Connection con){
        this.connection = con;
    }

    @Override
    public List<Problem> getAll(){
        List<Problem> problems = new ArrayList<>();
        try(Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(FIND_ALL_UNSOLVED_PROBLEMS)){
            while(rs.next()){
                problems.add(convertIntoLocation(rs));
            }
        }catch(SQLException e){
            LOGGER.error("Problem with getAll() problems statement!", e);
        }
        return problems;
    }

    private Problem convertIntoLocation(ResultSet rs) throws SQLException{
        Problem problem = new Problem();
        problem.setId(rs.getInt("id"));
        problem.setFromId(rs.getInt("from_id"));
        problem.setToId(rs.getInt("to_id"));
        return problem;
    }
}
