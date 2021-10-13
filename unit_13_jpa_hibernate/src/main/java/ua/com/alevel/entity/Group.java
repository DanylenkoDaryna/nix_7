package ua.com.alevel.entity;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(name = "group_name", unique = true)
    private String groupName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
//    @JoinColumn(name = "course_id", referencedColumnName = "course_name")
    @Access(AccessType.PROPERTY)
    private Course course;


    @OneToMany(mappedBy = "group")
    private List<Student> students;

    @OneToMany(mappedBy = "group")
    private List<Lesson> lessons;

    public Group(){
        students = new ArrayList<>();
        lessons = new ArrayList<>();
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getGroupName(){
        return groupName;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public Course getCourse(){
        return course;
    }

    public void setCourse(Course course){
        this.course = course;
    }

    public List<Student> getStudents(){
        return students;
    }

    public void setStudents(List<Student> students){
        this.students = students;
    }

    public List<Lesson> getLessons(){
        return lessons;
    }

    public void setLessons(List<Lesson> lessons){
        this.lessons = lessons;
    }

    public void addStudent(Student student){
        students.add(student);
        student.setGroup(this);
    }

    public void addLesson(Lesson lesson){
        lessons.add(lesson);
        lesson.setGroup(this);
    }
}
