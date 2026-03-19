package com.sna.homework002.repository;

import com.sna.homework002.model.entity.Course;
import com.sna.homework002.model.request.CourseRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(
                    property = "instructor",
                    column = "instructor_id",
                    one = @One(select = "com.sna.homework002.repository.InstructorReository.getInstructorById")
            )
    })
    @Select("""
     select *  from courses where course_id = #{id};
""")
    Course getCourseById(Integer id);
    @Select("""
    SELECT  c.course_id, c.course_name,c.description,c.instructor_id FROM student_course sc INNER JOIN courses c ON c.course_id = sc.course_id
    WHERE sc.student_id = #{id};
""")@ResultMap("courseMapper")
    List<Course> getAllCourseByStudentId(Integer id);

    @Select("""
     select *  from courses order by course_id asc
            offset #{size} *(#{page}-1)
       limit #{size}\s;
""")
    @ResultMap("courseMapper")
    List<Course> getAllCourse(Integer size, Integer page);
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
}
