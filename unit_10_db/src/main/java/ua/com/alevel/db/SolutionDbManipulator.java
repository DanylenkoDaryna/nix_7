package ua.com.alevel.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.db.util.ConnectionMaker;
import ua.com.alevel.db.util.Statements;
import ua.com.alevel.entity.Solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SolutionDbManipulator implements SolutionTable{

    private static final Logger LOGGER = LoggerFactory.getLogger("error");

    @Override
    public void addAll(List<Solution> solutions){
        try(Connection con = ConnectionMaker.getConnection()){
            con.setAutoCommit(false);
            try(PreparedStatement insertSolutionStmt = con.prepareStatement(Statements.INSERT_NEW_SOLUTION)){
                for(Solution solution : solutions){
                    insertSolutionStmt.setInt(1, solution.getProblemId());
                    insertSolutionStmt.setInt(2, solution.getFinalCost());
                    insertSolutionStmt.addBatch();
                }
                insertSolutionStmt.executeBatch();
                con.commit();
            }catch(SQLException e){
                LOGGER.error("error when add solutions batch PreparedStatement", e);
                con.rollback();
            }
        }catch(SQLException e){
            LOGGER.error("Problem with connection", e);
            System.out.println("Problem with connection!!");
        }
    }
}
