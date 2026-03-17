package com.sna.homework002.controller;

import com.sna.homework002.model.entity.Course;
import com.sna.homework002.model.entity.Instructor;
import com.sna.homework002.model.request.CourseRequest;
import com.sna.homework002.model.response.ApiResponse;
import com.sna.homework002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private  final CourseService coursseService;
    private final ResourceUrlProvider resourceUrlProvider;

    public CourseController(CourseService coursseService, ResourceUrlProvider resourceUrlProvider) {
        this.coursseService = coursseService;
        this.resourceUrlProvider = resourceUrlProvider;
    }

    @GetMapping("/student/{student-id}")
    public ResponseEntity<?> tAllCourseByStudentId(@PathVariable("student-id") Integer studentId) {
        ApiResponse<?> response=ApiResponse.<List<Course>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Get All Courses By Student Id Success")
                .payload(coursseService.getAllCourse())
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{course-id}")
    public ResponseEntity<?> getCourseById(@PathVariable("course-id") Integer courseId) {
        ApiResponse<?> response=ApiResponse.<Course>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Get Course By Course Id Success")
                .payload(coursseService.getCourseById(courseId))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response) ;
    }
    @GetMapping
    public ResponseEntity<?> getAllCourse() {
        ApiResponse<List<Course>> response=ApiResponse.<List<Course>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Get All Courses Success")
                .payload(coursseService.getAllCourse())
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<?> saveCourse(@RequestBody CourseRequest courseRequest) {
        ApiResponse<Course> response=ApiResponse.<Course>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Save course Success")
                .payload(coursseService.saveCourse(courseRequest))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{course-id}")
    public ResponseEntity<?> updateCourse(@PathVariable("course-id") Integer courseId, @RequestBody CourseRequest courseRequest) {
        ApiResponse<?> response=ApiResponse.<Course>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Update Course Success")
                .payload(coursseService.updateCourseByID(courseId,courseRequest))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{course-id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("course-id") Integer courseId) {
        coursseService.deleteByID(courseId);
        ApiResponse<?> response=ApiResponse.<String>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Delete Course Success")
                .payload("Delete Course Success")
                .timestamp(Instant.now())
                .build();
       return ResponseEntity.ok(response);
    }

}
