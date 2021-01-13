package app.dao;

import app.db.Database;
import app.entity.Student;

import java.util.List;


public class StudentDao {

    public Long insert(Student student) {
        return (Long) Database.getSession().save(student);
    }

    public void update(Student student) {
        Database.getSession().update(student);
    }

    public void delete(Student student) {
        Database.getSession().delete(student);
    }

    public Student getById(Long id) {
        return Database.getSession().get(Student.class, id);
    }

    public List<Student> getAll() {
        return Database.getSession().createQuery("from Student", Student.class).list();
    }
}
