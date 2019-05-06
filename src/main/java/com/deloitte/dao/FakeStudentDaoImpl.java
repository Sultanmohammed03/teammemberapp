package com.deloitte.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.deloitte.entity.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Profile("local")
public class FakeStudentDaoImpl implements StudentDao {

    private static Map<String, Student> students;

    static {

        students = new HashMap<String, Student>(){

            {
                put("1", new Student("Chintan", "Computer Science"));
                put("2", new Student("Sultan", "Finance"));
                put("3", new Student("Nayeem", "Maths"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    @Override
    public Student getStudentById(String id){
        return this.students.get(id);
    }

    @Override
    public void removeStudentById(String id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student){
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(), student);
    }

    @Override
    public void insertStudentToDb(Student student) {
        this.students.put(student.getId(), student);
    }
}
