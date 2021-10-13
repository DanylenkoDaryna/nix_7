package ua.com.alevel.dto;

import java.time.Instant;

public class LessonDto{

    private Long id;
    private String topic;
    private String group;
    private String lecturer;
    private Instant startDateTime;
    private Instant endDateTime;

    public LessonDto(){
    }

    @Override
    public String toString(){
        return "Lesson: " + id + "\n" +
                "Topic: \"" + topic + "\"\n" +
                "For group " + group + "\n" +
                "Lecturer is a " + lecturer + "\n" +
                "Start of lesson on " + startDateTime + "\n" +
                "End of lesson on " + endDateTime + "\n";
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTopic(){
        return topic;
    }

    public void setTopic(String topic){
        this.topic = topic;
    }

    public String getGroup(){
        return group;
    }

    public void setGroup(String group){
        this.group = group;
    }

    public String getLecturer(){
        return lecturer;
    }

    public void setLecturer(String lecturer){
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
