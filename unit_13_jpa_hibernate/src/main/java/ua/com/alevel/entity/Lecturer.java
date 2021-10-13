package ua.com.alevel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lecturers")
public class Lecturer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "lecturer")
    private List<Lesson> lessons;

    public Lecturer(){
        lessons = new ArrayList<>();
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

    public List<Lesson> getLessons(){
        return lessons;
    }

    public void setLessons(List<Lesson> lessons){
        this.lessons = lessons;
    }

    public void addLesson(Lesson lesson){
        lessons.add(lesson);
        lesson.setLecturer(this);

    }
}
