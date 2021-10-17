package ua.com.alevel.dao;

import org.hibernate.Session;
import ua.com.alevel.dto.UserDto;
import ua.com.alevel.entity.Count;
import ua.com.alevel.entity.Operation;
import ua.com.alevel.entity.OperationCategory;
import ua.com.alevel.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FinanceDaoHiber{

    public UserDto findUser(String email, EntityManager entityManager){
        UserDto userDto = new UserDto();
        User user = entityManager.unwrap(Session.class).bySimpleNaturalId(User.class).load(email);
        userDto.setId(user.getId());
        userDto.setEmail(email);
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPassword(user.getPassword());
        for(Count count : user.getCounts()){
            userDto.addCountId(count);
        }
        return userDto;
    }

    public Count findCount(int id, EntityManager entityManager){
        Count count = entityManager.find(Count.class, id);
        return count;
    }

    public void saveOperation(Operation operation, EntityManager entityManager){
        entityManager.getTransaction().begin();
        entityManager.persist(operation.getCategory());
        entityManager.persist(operation);
        entityManager.getTransaction().commit();
    }

    public List<OperationCategory> findAllCategories(EntityManager entityManager){
        entityManager.getTransaction().begin();
        TypedQuery<OperationCategory> query = entityManager.createQuery("from OperationCategory oc", OperationCategory.class);
        List<OperationCategory> categories = query.getResultList();
        entityManager.getTransaction().commit();
        return categories;
    }
}