package ua.com.alevel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.com.alevel.dto.LessonDto;
import ua.com.alevel.entity.Lesson;
import ua.com.alevel.entity.Student;

import javax.persistence.TypedQuery;
import java.time.Instant;

public class LessonDaoImpl implements LessonDao{

    private SessionFactory sessionFactory;

    public LessonDaoImpl(SessionFactory factory){
        sessionFactory = factory;
    }

    @Override
    public LessonDto getNextLesson(long studentId){
        LessonDto lessonDto = new LessonDto();
        Lesson lesson = new Lesson();
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            TypedQuery<Student> query1 = session.createQuery("from Student s where id=:id", Student.class)
                    .setParameter("id", studentId);
            Student student = query1.getSingleResult();
            System.out.println(Instant.now().toString());
            TypedQuery<Lesson> query2 = session.createQuery("from Lesson les where les.group = :group AND les.startDateTime > :datetime ", Lesson.class);
            query2.setParameter("group", student.getGroup());
            query2.setParameter("datetime", Instant.now());
            lesson = query2.getSingleResult();
            lessonDto.setId(lesson.getId());
            lessonDto.setGroup(lesson.getGroup().getGroupName());
            lessonDto.setTopic(lesson.getTopic().getTopicName());
            lessonDto.setLecturer(lesson.getLecturer().getFirstName() + " " + lesson.getLecturer().getLastName());
            lessonDto.setStartDateTime(lesson.getStartDateTime());
            lessonDto.setEndDateTime(lesson.getEndDateTime());
        }
        return lessonDto;
    }
}
