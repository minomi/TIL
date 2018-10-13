package student.dao;

import student.dto.Student;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 11..
 */
public class StudentDao {
    private Map<String, Student> db = new HashMap<>();

    public void insert(Student student) {
        System.out.println("학생 id : " + student.getId() + " insert");
        db.put(student.getId(), student);
    }

    public Student selectById(String id) {
        System.out.println("학생 id : " + id + " select");
        return db.get(id);
    }

    public Set<Student> selectAll() {
        return new HashSet<>(db.values());
    }

}
