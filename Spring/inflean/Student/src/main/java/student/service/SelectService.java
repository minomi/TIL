package service;

import dao.StudentDao;
import dto.Student;

import java.util.Set;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 11..
 */
public class SelectService {

    private StudentDao studentDao;

    public SelectService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student selectById(String id) {
        return studentDao.selectById(id);
    }

    public Set<Student> selectAll() {
        return studentDao.selectAll();
    }
}
