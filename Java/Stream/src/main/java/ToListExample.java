import java.util.*;
import java.util.stream.Collectors;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 04/11/2018.
 */
public class ToListExample {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("홍길동", 10, Student.Sex.MALE),
                new Student("김수애", 6, Student.Sex.FEMALE),
                new Student("신용권", 10, Student.Sex.MALE),
                new Student("박수미", 6, Student.Sex.FEMALE)
        );

        Set<Student> femaleStudents = students.stream()
                .filter(student -> student.getSex() == Student.Sex.FEMALE)
                .collect(Collectors.toSet());

        femaleStudents.stream()
                .map(Student::getName)
                .forEach(System.out::println);

        MaleStudents maleStudents = students.stream()
                .filter(Student::isMail)
                .collect(MaleStudents::new, MaleStudents::accumulate, MaleStudents::combine);

        maleStudents.getList()
                .stream()
                .map(Student::getName)
                .forEach(System.out::println);
    }

}
