package com.sna.homework002.service.impl;

import com.sna.homework002.model.entity.Course;
import com.sna.homework002.model.entity.Instructor;
import com.sna.homework002.model.request.CourseRequest;
import com.sna.homework002.repository.CourseRepository;
import com.sna.homework002.repository.InstructorReository;
import com.sna.homework002.service.CourseService;
import org.springdoc.core.utils.PropertyResolverUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
  private final   CourseRepository courseRepository;
    private final InstructorReository instructorRepository;

    public CourseServiceImpl(CourseRepository courseRepository, PropertyResolverUtils propertyResolverUtils, InstructorReository instructorRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Course> getAllCourseByStudentId(Integer id) {
        return courseRepository.getAllCourseByStudentId(id);
    }



    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourse(Integer size, Integer page) {
        return courseRepository.getAllCourse(size,page);
    }

    @Override
    public Course saveCourse(CourseRequest courseRequest) {
        Instructor instructor = instructorRepository.getInstructorById(courseRequest.getInstructorId());
        if (instructor == null) {
            return null;
        }
        return courseRepository.saveCourse(courseRequest);
    }

    @Override
    public Course updateCourseByID(Integer courseId, CourseRequest courseRequest) {
        Instructor instructor = instructorRepository.getInstructorById(courseRequest.getInstructorId());
        if (instructor == null) {
            return null;
        }
        return courseRepository.updateCourseByID(courseId,courseRequest);
    }

    @Override
    public void deleteByCourseID(Integer courseId) {
        courseRepository.deleteByID(courseId);

    }
}
