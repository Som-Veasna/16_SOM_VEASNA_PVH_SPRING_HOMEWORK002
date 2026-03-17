package com.sna.homework002.controller;

import com.sna.homework002.model.entity.Student;
import com.sna.homework002.model.request.StudentRequest;
import com.sna.homework002.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }
    @GetMapping("/{student-id}")
    public Student getStudentById(@PathVariable("student-id") Integer studentId) {
        return studentService.getStudentById(studentId);
    }
    @PostMapping
    public Student saveStudnet(@RequestBody StudentRequest studentRequest) {
        return studentService.saveStudent(studentRequest);
    }
     @DeleteMapping("/{student-id}")
    public String  deleteStudent(@PathVariable("student-id") Integer studentId) {
        studentService.deleteStudentByID(studentId);
        return "Student deleted successfully";
     }
     @PutMapping("/{student-id}")
    public Student updateStudent(@PathVariable("student-id") Integer studentId, @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudentById(studentId,studentRequest);
     }



}
