package com.javabanters.crudDemo.dao;

import com.javabanters.crudDemo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {

    void save(Student student);

    void saveAll(List<Student> students);

    Optional<Student> findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    Student update(Student student);

    void delete(Integer id);

    int deleteAll();

    //Integer updateMultiple(List<Student> students);
}
