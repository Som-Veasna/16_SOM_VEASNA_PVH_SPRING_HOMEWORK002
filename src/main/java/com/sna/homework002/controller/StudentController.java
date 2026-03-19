package com.sna.homework002.controller;

import com.sna.homework002.model.entity.Student;
import com.sna.homework002.model.request.StudentRequest;
import com.sna.homework002.model.response.ApiResponse;
import com.sna.homework002.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @Operation(summary = "Get all student")
    @GetMapping
    public ResponseEntity<?> getAllStudents(@RequestParam(defaultValue = "10") Integer size , @RequestParam(defaultValue = "1")Integer page) {
        ApiResponse<?> response=ApiResponse.<List<Student>>builder()
                .success(true)
                .message("Get All Students Successfully")
                .status(HttpStatus.OK.value())
                .payload(studentService.getAllStudent(size , page))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Get student by id")
    @GetMapping("/{student-id}")
    public ResponseEntity<?> getStudentById(@PathVariable("student-id") Integer studentId) {
       Student student= studentService.getStudentById(studentId);
       if(student==null){
           ApiResponse<Void>response=ApiResponse.<Void>builder()
                   .success(false)
                   .status(HttpStatus.NOT_FOUND.value())
                   .message("Student not found with id " + studentId)
                   .timestamp(Instant.now())
                   .build();
           return ResponseEntity.ok(response);
       }

        ApiResponse<Student> response=ApiResponse.<Student>builder()
                .success(true)
                .message("Get Student Successfully")
                .status(HttpStatus.OK.value())
                .payload(studentService.getStudentById(studentId))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Create student")
    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody StudentRequest studentRequest) {
        Student student = studentService.saveStudent(studentRequest);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.<Void>builder()
                            .success(false)
                            .status(HttpStatus.NOT_FOUND.value())
                            .message("Course not found with id " + studentRequest.getCourseId())
                            .timestamp(Instant.now())
                            .build());
        }
        ApiResponse<Student> response=ApiResponse.<Student>builder()
                .success(true)
                .message("Save Student Successfully")
                .status(HttpStatus.CREATED.value())
                .payload(studentService.saveStudent(studentRequest))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Delete student by id")
     @DeleteMapping("/{student-id}")
    public ResponseEntity<?>  deleteStudent(@PathVariable("student-id") Integer studentId) {
        Student student=  studentService.getStudentById(studentId);
        if(student==null){
            return getStudentById(studentId);
        }
        studentService.deleteStudentByID(studentId);
        ApiResponse<?> response=ApiResponse.<String>builder()
                .success(true)
                .message("Delete Student Successfully")
                .status(HttpStatus.OK.value())
                .payload("Student Deleted Successfully")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
     }
    @Operation(summary = "Update student by id")
     @PutMapping("/{student-id}")
    public ResponseEntity<?> updateStudent(@PathVariable("student-id") Integer studentId, @RequestBody StudentRequest studentRequest) {
          Student foundStudent=  studentService.getStudentById(studentId);
        if(foundStudent==null){
            return getStudentById(studentId);
        }
        Student student=studentService.updateStudentById(studentId,studentRequest);
        if (student==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.<Void>builder()
                            .success(false)
                            .status(HttpStatus.NOT_FOUND.value())
                            .message("Course not found with id " + studentRequest.getCourseId())
                            .timestamp(Instant.now())
                            .build());
        }
        ApiResponse<?> response=ApiResponse.<Student>builder()
                .success(true)
                .message("Update Student Successfully")
                .status(HttpStatus.OK.value())
                .payload( student)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
     }
}
