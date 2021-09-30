package ua.com.alevel.entity;

import ua.com.alevel.mapper.CsvMapping;

import java.time.LocalDate;

public class UserDetails{

    @CsvMapping("id")
    private long id;

    @CsvMapping("firstName")
    private String firstName;

    @CsvMapping("middleName")
    private String middleName;

    @CsvMapping("lastName")
    private String lastName;

    @CsvMapping("birthDate")
    private LocalDate birthDate;

    @CsvMapping("gender")
    private Gender gender;

    @CsvMapping("active")
    private boolean active;

    @CsvMapping("engagementScore")
    private double engagementScore;

    public UserDetails(){
    }

    public UserDetails(long id, String firstName, String lastName, LocalDate birthDate, Gender gender, boolean active, double engagementScore){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.active = active;
        this.engagementScore = engagementScore;
    }

    @Override
    public String toString(){
        return "UserDetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", active=" + active +
                ", engagementScore=" + engagementScore +
                '}';
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
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

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    public Gender getGender(){
        return gender;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public double getEngagementScore(){
        return engagementScore;
    }

    public void setEngagementScore(double engagementScore){
        this.engagementScore = engagementScore;
    }
}
