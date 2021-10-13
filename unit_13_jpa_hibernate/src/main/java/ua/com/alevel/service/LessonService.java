package ua.com.alevel.service;

import ua.com.alevel.dto.LessonDto;

public interface LessonService{

    LessonDto getNextLesson(long studentId);
}
