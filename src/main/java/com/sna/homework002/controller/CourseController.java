package com.sna.homework002.controller;

import com.sna.homework002.model.entity.Course;
import com.sna.homework002.model.request.CourseRequest;
import com.sna.homework002.service.CourseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.List;

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
    public List<Course> getAllCourseByStudentId(@PathVariable("student-id") Integer studentId) {
        return coursseService.getAllCourseByStudentId(studentId);
    }
    @GetMapping("/{course-id}")
    public Course getCourseById(@PathVariable("course-id") Integer courseId) {
        return coursseService.getCourseById(courseId);
    }
    @GetMapping
    public List<Course> getAllCourse() {
        return coursseService.getAllCourse();
    }
    @PostMapping
    public Course saveCourse(@RequestBody CourseRequest courseRequest) {
        return coursseService.saveCourse(courseRequest);
    }

    @PutMapping("/{course-id}")
    public Course updateCourse(@PathVariable("course-id") Integer courseId, @RequestBody CourseRequest courseRequest) {
        return coursseService.updateCourseByID(courseId,courseRequest);
    }
    @DeleteMapping("/{course-id}")
    public String deleteCourse(@PathVariable("course-id") Integer courseId) {
       coursseService.deleteByID(courseId);
       return "Course deleted successfully";
    }

}
