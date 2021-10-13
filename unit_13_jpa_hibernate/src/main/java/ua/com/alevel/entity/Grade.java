package ua.com.alevel.entity;

import javax.persistence.*;

@Entity
@Table(name = "grades")
public class Grade{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "grade_value")
    private int gradeValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @Access(AccessType.PROPERTY)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    @Access(AccessType.PROPERTY)
    private Lesson lesson;


    public Grade(){
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public int getGradeValue(){
        return gradeValue;
    }

    public void setGradeValue(int gradeValue){
        this.gradeValue = gradeValue;
    }

    public Student getStudent(){
        return student;
    }

    public void setStudent(Student student){
        this.student = student;
    }

    public Lesson getLesson(){
        return lesson;
    }

    public void setLesson(Lesson lesson){
        this.lesson = lesson;
    }
}
