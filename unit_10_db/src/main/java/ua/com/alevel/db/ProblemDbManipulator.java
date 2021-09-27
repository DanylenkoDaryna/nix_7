package ua.com.alevel.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.db.util.ConnectionMaker;
import ua.com.alevel.db.util.Statements;
import ua.com.alevel.entity.Problem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProblemDbManipulator implements ProblemTable{

    private static final Logger LOGGER = LoggerFactory.getLogger(ProblemDbManipulator.class);

    @Override
    public List<Problem> getAll(){
        List<Problem> problems = new ArrayList<>();
        try(Connection con = ConnectionMaker.getConnection()){
            try(Statement statement = con.createStatement()){
                ResultSet rs = statement.executeQuery(Statements.FIND_ALL_PROBLEMS);
                while(rs.next()){
                    problems.add(convertIntoLocation(rs));
                }
            }catch(SQLException e){
                LOGGER.error("Problem with getAll() problems statement!", e);
            }
        }catch(SQLException e){
            LOGGER.error("Problem with connection", e);
            System.out.println("Problem with connection!!");
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