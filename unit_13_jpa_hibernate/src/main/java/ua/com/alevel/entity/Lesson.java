package ua.com.alevel.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "lessons")
public class Lesson{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    @Access(AccessType.PROPERTY)
    private Topic topic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    @Access(AccessType.PROPERTY)
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id")
    @Access(AccessType.PROPERTY)
    private Lecturer lecturer;

    @Column(name = "start_date_time")
    private Instant startDateTime;

    @Column(name = "end_date_time")
    private Instant endDateTime;

    public Lesson(){
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Topic getTopic(){
        return topic;
    }

    public void setTopic(Topic topic){
        this.topic = topic;
    }

    public Group getGroup(){
        return group;
    }

    public void setGroup(Group group){
        this.group = group;
    }

    public Lecturer getLecturer(){
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer){
        this.lecturer = lecturer;
    }

    public Instant getStartDateTime(){
        return startDateTime;
    }

    public void setStartDateTime(Instant startDateTime){
        this.startDateTime = startDateTime;
    }

    public Instant getEndDateTime(){
        return endDateTime;
    }

    public void setEndDateTime(Instant endDateTime){
        this.endDateTime = endDateTime;
    }
}
