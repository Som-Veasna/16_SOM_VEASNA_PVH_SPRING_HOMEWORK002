package com.sna.homework002.service;

import com.sna.homework002.model.entity.Course;
import com.sna.homework002.model.request.CourseRequest;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourseByStudentId(Integer id);
    Course getCourseById(Integer id);
    List<Course> getAllCourse(Integer size, Integer page);
    Course saveCourse(CourseRequest courseRequest);
    Course updateCourseByID(Integer courseId, CourseRequest courseRequest);
    void deleteByID(Integer courseId);

}
