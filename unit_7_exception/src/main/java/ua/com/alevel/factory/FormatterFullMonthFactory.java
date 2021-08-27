package ua.com.alevel.factory;

import ua.com.alevel.formatter.Formatter;
import ua.com.alevel.formatter.FormatterFullMonth;

public class FormatterFullMonthFactory implements FormatterFactory{

    @Override
    public Formatter createFormatter(String format){
        return new FormatterFullMonth();
    }
}
