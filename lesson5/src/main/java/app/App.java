package app;

import app.dao.StudentDao;
import app.db.Database;
import app.entity.Student;

import java.util.List;

public class App {

    public static void main(String[] args) {
        Database.openSession();
        StudentDao studentDao = new StudentDao();
        Student student = new Student("Student1", 5);
        Long id = studentDao.insert(student);
        Database.closeSession();

        Database.openSession();
        student = studentDao.getById(id);
        student.setMark(4);
        studentDao.update(student);
        Database.closeSession();

        Database.openSession();
        student = studentDao.getById(id);
        System.out.println(student);
        studentDao.delete(student);
        Database.closeSession();

        Database.openSession();
        List<Student> students = studentDao.getAll();
        System.out.println(students);
        Database.closeSession();
    }
}
