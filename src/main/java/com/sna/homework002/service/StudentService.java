package com.sna.homework002.service;

import com.sna.homework002.model.entity.Student;
import com.sna.homework002.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent(Integer size,Integer page);

    Student getStudentById(Integer studentId);

    Student saveStudent(StudentRequest studentRequest);

    void deleteStudentByID(Integer studentId);

    Student updateStudentById(Integer studentId, StudentRequest studentRequest);
}
