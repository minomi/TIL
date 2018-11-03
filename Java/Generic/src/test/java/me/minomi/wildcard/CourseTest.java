package me.minomi.wildcard;

import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 03/11/2018.
 */
public class CourseTest {

    @Test
    public void registerPersonCourse() {
        Course<Person> personCourse = new Course<>("일반인 코스");
        personCourse.add(new Student("학생 A"));
        personCourse.add(new HighStudent("고등학생 B"));
        personCourse.add(new Worker("직장인 C"));
        personCourse.add(new Person("그냥 인간 D"));

        Course<Worker> workerCourse = new Course<>("직장인 코스");
        workerCourse.add(new Worker("직장인 A"));
        workerCourse.add(new Worker("직장인 B"));

        Course<Student> studentCourse = new Course<>("학생 코스");
        studentCourse.add(new Student("학생 A"));
        studentCourse.add(new Student("학생 B"));

        Course.registerPersonCourse(personCourse);
        // Course.registerWorkerCourse(studentCourse);
        Course.registerWorkerCourse(workerCourse);
    }

}