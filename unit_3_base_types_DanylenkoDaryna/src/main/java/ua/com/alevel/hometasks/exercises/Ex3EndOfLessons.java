package ua.com.alevel.hometasks.exercises;


public class Ex3EndOfLessons {

    private static final int LESSON_DURATION = 45;
    private static final int LONG_BREAK = 15;
    private static final int SHORT_BREAK = 5;
    private static final int HOUR_OF_FIRST_LESSON = 9;

    public static final String EX_3_DESCRIPTION = "To find out the end of the lesson, please, input number of your lesson in the range 1-10:";
    public static final String STOP_EX = "enter \'stop\' or \'exit\' or \'q\' to stop exercise";

    private Ex3EndOfLessons(){
        throw new IllegalStateException("Utility class");
    }

    public static void exercise3(int lessonNumber) {
        System.out.println(EX_3_DESCRIPTION +"\n"+ STOP_EX);
        int timeToLessonEnd = lessonNumber * LESSON_DURATION + countBreaks(lessonNumber);
        int endLessonHours = HOUR_OF_FIRST_LESSON + timeToLessonEnd / 60;
        int endLessonMinutes = timeToLessonEnd % 60;
                System.out.println(endLessonHours + " " + endLessonMinutes);
    }

    private static int countBreaks(int lessonNum) {
        int countShortBreaks = lessonNum/2;
        int countLongBreaks = (lessonNum-1) - countShortBreaks;
        return countShortBreaks*SHORT_BREAK + countLongBreaks*LONG_BREAK;
    }
}

