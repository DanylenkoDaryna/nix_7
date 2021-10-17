package ua.com.alevel.dto;

import ua.com.alevel.entity.Count;

import java.util.ArrayList;
import java.util.List;

public class UserDto{

    private int id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private List<Integer> countIds;

    public UserDto(){
        countIds = new ArrayList<>();
    }

    @Override
    public String toString(){
        return "UserDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", countIds=" + countIds +
                '}';
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public List<Integer> getCountIds(){
        return countIds;
    }

    public void setCountIds(List<Integer> countIds){
        this.countIds = countIds;
    }

    public void addCountId(Count count){
        countIds.add(count.getId());
    }

    public void addCountId(int countId){
        countIds.add(countId);
    }
}
