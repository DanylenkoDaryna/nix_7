package ua.com.alevel.service;

import org.hibernate.SessionFactory;
import ua.com.alevel.dao.LessonDao;
import ua.com.alevel.dao.LessonDaoImpl;
import ua.com.alevel.dto.LessonDto;

public class LessonServiceImpl implements LessonService{

    private LessonDao lessonDao;

    public LessonServiceImpl(SessionFactory factory){
        lessonDao = new LessonDaoImpl(factory);
    }

    @Override
    public LessonDto getNextLesson(long studentId){
        return lessonDao.getNextLesson(studentId);
    }
}
