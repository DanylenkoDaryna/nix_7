package ua.com.alevel.entity;

import ua.com.alevel.formatter.Formatter;

public class CalendarDate implements Comparable<CalendarDate>{

    private Formatter formatter;
    private int year;
    private Month month;
    private int day;
    private int hours;
    private int minutes;
    private int seconds;
    private long milliseconds;

    private long AverageMills;

    public CalendarDate(Formatter formatter){
        this.formatter = formatter;
    }

    public CalendarDate(){
    }

    public Formatter getFormatter(){
        return formatter;
    }

    public void setFormatter(Formatter formatter){
        this.formatter = formatter;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public Month getMonth(){
        return month;
    }

    public void setMonth(Month month){
        this.month = month;
    }

    public int getDay(){
        return day;
    }

    public void setDay(int day){
        this.day = day;
    }

    public int getHours(){
        return hours;
    }

    public void setHours(int hours){
        this.hours = hours;
    }

    public int getMinutes(){
        return minutes;
    }

    public void setMinutes(int minutes){
        this.minutes = minutes;
    }

    public int getSeconds(){
        return seconds;
    }

    public void setSeconds(int seconds){
        this.seconds = seconds;
    }

    public long getMilliseconds(){
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds){
        this.milliseconds = milliseconds;
    }

    public long getAverageMills(){
        return AverageMills;
    }

    public void setAverageMills(long averageMills){
        AverageMills = averageMills;
    }

    @Override
    public int compareTo(CalendarDate o){
        return Long.compare(this.getAverageMills(), o.getAverageMills());
    }

    @Override
    public boolean equals(Object obj){
        CalendarDate calendarDate = (CalendarDate) obj;
        return this.getAverageMills() == calendarDate.getAverageMills();
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }
}
