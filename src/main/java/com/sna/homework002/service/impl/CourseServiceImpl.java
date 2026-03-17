package com.sna.homework002.service.impl;

import com.sna.homework002.model.entity.Course;
import com.sna.homework002.model.request.CourseRequest;
import com.sna.homework002.model.response.StudentCourseResponse;
import com.sna.homework002.repository.CourseRepository;
import com.sna.homework002.service.CourseService;
import org.springdoc.core.utils.PropertyResolverUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
  private final   CourseRepository courseRepository;
    private final PropertyResolverUtils propertyResolverUtils;

    public CourseServiceImpl(CourseRepository courseRepository, PropertyResolverUtils propertyResolverUtils) {
        this.courseRepository = courseRepository;
        this.propertyResolverUtils = propertyResolverUtils;
    }

    @Override
    public List<Course> getAllCourseByStudentId(Integer id) {
        return courseRepository.getAllCourseByStudentId(id);
    }

    @Override
    public StudentCourseResponse getStudentCourse(Integer id) {

        return null;
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.getAllCiurse();
    }

    @Override
    public Course saveCourse(CourseRequest courseRequest) {
        return courseRepository.saveCourse(courseRequest);
    }

    @Override
    public Course updateCourseByID(Integer courseId, CourseRequest courseRequest) {
        return courseRepository.updateCourseByID(courseId,courseRequest);
    }

    @Override
    public void deleteByID(Integer courseId) {
        courseRepository.deleteEnrollmentsByCourseId(courseId);   // delete join table first
        courseRepository.deleteByID(courseId);

    }
}
