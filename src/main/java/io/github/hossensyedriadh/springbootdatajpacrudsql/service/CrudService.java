package io.github.hossensyedriadh.springbootdatajpacrudsql.service;

import io.github.hossensyedriadh.springbootdatajpacrudsql.entity.Student;

import java.util.List;

public interface CrudService {
    List<Student> getStudents();

    Student getStudent(Integer id);

    Student addStudent(Student student);

    Student updateStudent(Student updatedStudent);

    void deleteStudent(Integer id);
}
