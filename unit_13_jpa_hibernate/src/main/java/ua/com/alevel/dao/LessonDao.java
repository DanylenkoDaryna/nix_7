package ua.com.alevel.dao;

import ua.com.alevel.dto.LessonDto;

public interface LessonDao{

    LessonDto getNextLesson(long studentId);
}
