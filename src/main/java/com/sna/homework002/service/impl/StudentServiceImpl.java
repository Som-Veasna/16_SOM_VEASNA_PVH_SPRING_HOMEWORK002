package com.sna.homework002.service.impl;

import com.sna.homework002.model.entity.Student;
import com.sna.homework002.model.request.StudentRequest;
import com.sna.homework002.repository.StudentCourseReposity;
import com.sna.homework002.repository.StudentRepository;
import com.sna.homework002.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private StudentCourseReposity studentCourseReposity;

    public StudentServiceImpl(StudentRepository studentRepository, StudentCourseReposity studentCourseReposity) {
        this.studentRepository = studentRepository;
        this.studentCourseReposity = studentCourseReposity;
    }

    @Override
    public List<Student> getAllStudent(@RequestParam(defaultValue = "10") Integer size , @RequestParam(defaultValue = "1")Integer page) {
        return studentRepository.getAllStudent(size,page);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public Student saveStudent(StudentRequest studentRequest) {
        Student student =studentRepository.saveStudent(studentRequest);
        for(Integer courseId:studentRequest.getCourseId()){
           studentCourseReposity.saveStudentCourse(student.getStudentId(),courseId);
        }
        return getStudentById(student.getStudentId());
    }

    @Override
    public void deleteStudentByID(Integer studentId) {
      var foundStudent=getStudentById(studentId);
      if (foundStudent!=null){
          studentCourseReposity.deleteStudentCourse(studentId);
          studentRepository.deleteStudentByID(studentId);
      }
    }

    @Override
    public Student updateStudentById(Integer studentId,StudentRequest studentRequest) {
       Student updateStudent=studentRepository.updateStudent(studentId,studentRequest);
        studentCourseReposity.deleteStudentCourse(studentId);
           for(Integer courseId:studentRequest.getCourseId()){
               studentCourseReposity.saveStudentCourse(updateStudent.getStudentId(),courseId);
           }

        return studentRepository.getStudentById(updateStudent.getStudentId());
    }
}
