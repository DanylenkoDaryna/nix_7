package ua.com.alevel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topics")
public class Topic{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "topic_name", nullable = false)
    private String topicName;

    @OneToMany(mappedBy = "topic")
    private List<Lesson> lessons;

    public Topic(){
        lessons = new ArrayList<>();
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTopicName(){
        return topicName;
    }

    public void setTopicName(String topicName){
        this.topicName = topicName;
    }

    public List<Lesson> getLessons(){
        return lessons;
    }

    public void setLessons(List<Lesson> lessons){
        this.lessons = lessons;
    }

    public void addLesson(Lesson lesson){
        lessons.add(lesson);
        lesson.setTopic(this);

    }
}
