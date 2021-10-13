package ua.com.alevel.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(name = "course_name", unique = true)
    private String courseName;

    @OneToMany(mappedBy = "course")
    private List<Group> groups;

    public Course(){
        groups = new ArrayList<>();
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public List<Group> getGroups(){
        return groups;
    }

    public void setGroups(List<Group> groups){
        this.groups = groups;
    }

    public void addGroup(Group group){
        groups.add(group);
        group.setCourse(this);
    }
}
