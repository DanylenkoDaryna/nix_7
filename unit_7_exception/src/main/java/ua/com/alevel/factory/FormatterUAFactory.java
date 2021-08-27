package ua.com.alevel.factory;

import ua.com.alevel.formatter.Formatter;
import ua.com.alevel.formatter.FormatterUA;

public class FormatterUAFactory implements FormatterFactory{
    @Override
    public Formatter createFormatter(String format){
        return new FormatterUA();
    }
}
