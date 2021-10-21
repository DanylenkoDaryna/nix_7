package ua.com.alevel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.com.alevel.dto.LessonDto;
import ua.com.alevel.entity.Lesson;
import ua.com.alevel.entity.Student;

import javax.persistence.TypedQuery;
import java.time.Instant;
import java.util.Optional;

public class LessonDaoImpl implements LessonDao{

    private SessionFactory sessionFactory;

    public LessonDaoImpl(SessionFactory factory){
        sessionFactory = factory;
    }

    @Override
    public LessonDto getNextLesson(long studentId){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            TypedQuery<Student> query1 = session.createQuery("from Student s where id=:id", Student.class)
                    .setParameter("id", studentId);
            Student student = query1.getSingleResult();
            System.out.println(Instant.now().toString());
            TypedQuery<Lesson> query2 = session.createQuery("from Lesson les where les.group = :group AND" +
                    " les.startDateTime > :datetime order by les.startDateTime", Lesson.class);
            query2.setParameter("group", student.getGroup());
            query2.setParameter("datetime", Instant.now());
            Optional<Lesson> foundLesson = query2.getResultStream().findAny();
            if(foundLesson.isPresent()){
                LessonDto lessonDto = new LessonDto();
                lessonDto.setId(foundLesson.get().getId());
                lessonDto.setGroup(foundLesson.get().getGroup().getGroupName());
                lessonDto.setTopic(foundLesson.get().getTopic().getTopicName());
                lessonDto.setLecturer(foundLesson.get().getLecturer().getFirstName()
                        + " " + foundLesson.get().getLecturer().getLastName());
                lessonDto.setStartDateTime(foundLesson.get().getStartDateTime());
                lessonDto.setEndDateTime(foundLesson.get().getEndDateTime());
                return lessonDto;
            }else{
                return new LessonDto();
            }
        }
    }
}