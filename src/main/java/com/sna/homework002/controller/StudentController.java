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

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @Operation(summary = "Get all student")
    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        ApiResponse<?> response=ApiResponse.<List<Student>>builder()
                .success(true)
                .message("Get All Students Successfully")
                .status(HttpStatus.OK.value())
                .payload(studentService.getAllStudent())
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Get student by id")
    @GetMapping("/{student-id}")
    public ResponseEntity<?> getStudentById(@PathVariable("student-id") Integer studentId) {
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
    public ResponseEntity<?> saveStudnet(@RequestBody StudentRequest studentRequest) {
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
        ApiResponse<?> response=ApiResponse.<Student>builder()
                .success(true)
                .message("Update Student Successfully")
                .status(HttpStatus.OK.value())
                .payload( studentService.updateStudentById(studentId,studentRequest))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
     }

}
