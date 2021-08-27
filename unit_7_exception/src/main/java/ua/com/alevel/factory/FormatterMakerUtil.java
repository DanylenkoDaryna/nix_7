package ua.com.alevel.factory;


import ua.com.alevel.exceptions.CalendarUnknownFormatException;
import ua.com.alevel.formatter.Formatter;

public class FormatterMakerUtil{

    public static Formatter getFormatter(String format) throws Exception{

        return getFormatterFactory(format).createFormatter(format);
    }

    public static FormatterFactory getFormatterFactory(String format) throws CalendarUnknownFormatException{
        if(format.equals("dd/mm/yy")){
            return new FormatterUAFactory();
        }else if(format.equals("m/d/yyyy")){
            return new FormatterUSAFactory();
        }else if(format.equals("mmm-d-yy")){
            return new FormatterFullMonthFactory();
        }else if(format.equals("dd-mmm-yyyy 00:00")){
            return new FormatterWithTimeFatory();
        }else{
            throw new CalendarUnknownFormatException("Format " + format + " is unknown.");
        }
    }
}
