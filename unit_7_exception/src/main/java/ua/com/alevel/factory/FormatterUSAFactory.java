package ua.com.alevel.factory;

import ua.com.alevel.formatter.Formatter;
import ua.com.alevel.formatter.FormatterUSA;

public class FormatterUSAFactory implements FormatterFactory{
    @Override
    public Formatter createFormatter(String format){
        return new FormatterUSA();
    }
}
