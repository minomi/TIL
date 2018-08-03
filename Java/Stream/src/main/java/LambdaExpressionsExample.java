import java.util.Arrays;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 1..
 */

public class LambdaExpressionsExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("홍길동", 10), new Student("신용권", 20));
        students.stream().forEach(student -> {
            System.out.println(student.getName());
        });
    }
}
