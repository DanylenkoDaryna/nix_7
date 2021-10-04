package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SolutionDaoImpl implements SolutionDao{

    private static final Logger LOGGER = LoggerFactory.getLogger(SolutionDaoImpl.class);
    public static final String INSERT_NEW_SOLUTION = "insert into solutions(problem_id, cost) values(?,?)";
    private Connection connection;

    public SolutionDaoImpl(Connection con){
        this.connection = con;
    }

    @Override
    public void addAll(List<Solution> solutions){
        try{
            connection.setAutoCommit(false);
        }catch(SQLException e){
            LOGGER.error("Problem with setAutoCommit", e);
        }
        try(PreparedStatement insertSolutionStmt = connection.prepareStatement
                (INSERT_NEW_SOLUTION)){
            for(Solution solution : solutions){
                insertSolutionStmt.setInt(1, solution.getProblemId());
                insertSolutionStmt.setInt(2, solution.getFinalCost());
                insertSolutionStmt.addBatch();
            }
            insertSolutionStmt.executeBatch();
            connection.commit();
        }catch(SQLException e){
            LOGGER.error("Error when add solutions batch PreparedStatement", e);
            try{
                connection.rollback();
            }catch(SQLException e1){
                LOGGER.error("Problem with rollback", e);
            }
        }
    }
}
