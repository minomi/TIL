import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-02.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StringValueInjection {
    String value() default "StringValueInjection 으로 주입된 문자열 값이다.";
}
