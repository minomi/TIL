package me.minomi.wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 03/11/2018.
 */

/**
 * S 타입의 학생이 수강하는 코스
 * @param <S>
 */
public class Course<S> {
    private String name;
    private List<S> students = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public void add(S student) {
        students.add(student);
    }

    public void showStudentsList() {
        for (S student : students) {
            System.out.println(student);
        }
    }

    static public void registerPersonCourse (Course<? extends Person> personCourse) {
        personCourse.showStudentsList();
        System.out.println("일반인 코스 등록 완료");
    }

    static public void registerWorkerCourse (Course<? super Worker> workerCourse) {
        workerCourse.showStudentsList();
        System.out.println("직장인 코스 등록 완료");
    }
}
