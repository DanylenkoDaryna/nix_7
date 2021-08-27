package ua.com.alevel.factory;

import ua.com.alevel.formatter.Formatter;

public interface FormatterFactory{

    Formatter createFormatter(String format);
}
