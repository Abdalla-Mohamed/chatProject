package iti.chat.annotions;



import iti.chat.config.Config;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = { ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DateType {
    String dateFormat=Config.dateFormat;
}
