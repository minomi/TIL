import java.util.Arrays;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 1..
 */
public class MapAndReduceExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

        double avg = students.stream().mapToInt(Student::getScore).average().getAsDouble();
        System.out.println("평균 점수: " + avg);

        int sum = students.stream()
                .map(Student::getScore)
                .reduce(0, (s1, s2) -> s1 + s2);

        System.out.println("합 : " + sum);
    }
}
