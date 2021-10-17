package ua.com.alevel.dao;

import org.hibernate.Session;
import ua.com.alevel.dto.OperationDto;
import ua.com.alevel.dto.UserDto;

import javax.persistence.EntityManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FinanceDaoJdbc{

    private static final String GET_USER_QUERY = "select * from users where email = ?";
    private static final String GET_USERS_COUNTS_QUERY = "select * from counts where user_id = ?";
    private static final String GET_COUNT_OPERATIONS_QUERY = "SELECT operations.id,count_id,date_time,money,category_id,category_type,purpose" +
            " FROM operations left join categories on operations.category_id=categories.id where count_id=? and date_time " +
            "between ? and ?";

    public UserDto findUser(String email, EntityManager entityManager){
        return entityManager.unwrap(Session.class).doReturningWork(connection -> {
            connection.setAutoCommit(false);
            UserDto dto = new UserDto();
            try(PreparedStatement ps = connection.prepareStatement(GET_USER_QUERY);
                PreparedStatement ps2 = connection.prepareStatement(GET_USERS_COUNTS_QUERY)){
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    dto.setId(rs.getInt("id"));
                    dto.setEmail(email);
                    dto.setFirstName(rs.getString("first_name"));
                    dto.setLastName(rs.getString("last_name"));
                    dto.setPassword(rs.getString("password"));
                }
                ps2.setInt(1, dto.getId());
                rs = ps2.executeQuery();
                while(rs.next()){
                    dto.addCountId(rs.getInt("id"));
                }
            }
            return dto;
        });
    }

    public List<OperationDto> getOperations(int countId, Instant startDate, Instant endDate, EntityManager entityManager){
        return entityManager.unwrap(Session.class).doReturningWork(connection -> {
            connection.setAutoCommit(false);
            List<OperationDto> list = new ArrayList<>();
            try(PreparedStatement ps = connection.prepareStatement(GET_COUNT_OPERATIONS_QUERY)){
                ps.setInt(1, countId);
                ps.setTimestamp(2, Timestamp.from(startDate));
                ps.setTimestamp(3, Timestamp.from(endDate));
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    OperationDto dto = new OperationDto();
                    dto.setOperationId(rs.getString("id"));
                    dto.setCountId(rs.getString("count_id"));
                    Instant instant = rs.getTimestamp("date_time").toInstant();
                    String dateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.systemDefault()).format(instant);
                    dto.setDateTime(dateTime);
                    dto.setMoney(rs.getString("money"));
                    dto.setCategoryId(rs.getString("category_id"));
                    dto.setCategoryType(rs.getString("category_type"));
                    dto.setPurpose(rs.getString("purpose"));
                    list.add(dto);
                }
            }
            return list;
        });
    }
}
