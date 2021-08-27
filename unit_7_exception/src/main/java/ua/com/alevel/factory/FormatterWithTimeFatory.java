package ua.com.alevel.factory;

import ua.com.alevel.formatter.Formatter;
import ua.com.alevel.formatter.FormatterWithTime;

public class FormatterWithTimeFatory implements FormatterFactory{

    @Override
    public Formatter createFormatter(String format){
        return new FormatterWithTime();
    }
}
