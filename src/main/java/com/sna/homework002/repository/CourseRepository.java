package com.sna.homework002.repository;

import com.sna.homework002.model.entity.Course;
import com.sna.homework002.model.request.CourseRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Results(id = "courseMapper", value = {
            @Result(property = "id", column = "course_id"),
            @Result(property = "name", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(
                    property = "instructor",
                    column = "instructor_id",
                    one = @One(select = "com.sna.homework002.repository.InstructorReository.getInstructorById")
            )
    })
    @Select("""
    SELECT 
        c.course_id,
        c.course_name,
        c.description,
        c.instructor_id
    FROM student_course sc
    INNER JOIN courses c
        ON c.course_id = sc.course_id
    WHERE sc.student_id = #{id};
""")
    List<Course> getAllCourseByStudentId(Integer id);

    @Select("""
    SELECT 
        s.student_id,
        s.student_name,
        c.course_id,
        c.course_name,
        c.description,
        c.instructor_id
    FROM student_course sc
    JOIN students s ON s.student_id = sc.student_id
    JOIN courses c ON c.course_id = sc.course_id
    WHERE s.student_id = #{id};
""")
    List<CourseRequest> getAllCourseRequestByStudentId(Integer id);

    @Select("""
     select *  from courses where course_id = #{id};
""")
    @ResultMap("courseMapper")
    Course getCourseById(Integer id);

    @Select("""
     select *  from courses;
""")
    @ResultMap("courseMapper")
    List<Course> getAllCiurse();

    @Select("""
     insert into courses (course_name, description, instructor_id) values (#{request.courseName}, #{request.description}, #{request.instructorId}) returning *;
""")
    @ResultMap("courseMapper")
    Course saveCourse(@Param("request") CourseRequest courseRequest);

    @Select("""
    update courses set course_name = #{request.courseName}, description=#{request.description}, instructor_id=#{request.instructorId}  where course_id = #{courseId} returning *;
""")
    @ResultMap("courseMapper")
    Course updateCourseByID(Integer courseId, @Param("request") CourseRequest courseRequest);
    @Delete("DELETE FROM courses WHERE course_id = #{courseId}")
    void deleteByID(Integer courseId);
    @Delete("DELETE FROM student_course WHERE course_id = #{courseId}")
    void deleteEnrollmentsByCourseId(Integer courseId);
}
