package ua.com.alevel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "students")
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    @Access(AccessType.PROPERTY)
    private Group group;

    @OneToMany(mappedBy = "student")
    private List<Grade> grades;

    public Student(){
        grades = new ArrayList<>();
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getMiddleName(){
        return middleName;
    }

    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public Group getGroup(){
        return group;
    }

    public void setGroup(Group group){
        this.group = group;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public List<Grade> getGrades(){
        return grades;
    }

    public void setGrades(List<Grade> grades){
        this.grades = grades;
    }

    public void addGrade(Grade grade){
        grades.add(grade);
        grade.setStudent(this);
    }
}
