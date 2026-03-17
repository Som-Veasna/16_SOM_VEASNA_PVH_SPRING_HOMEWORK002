package com.sna.homework002.repository;
import org.apache.ibatis.annotations.*;
@Mapper
public interface StudentCourseReposity {
    @Insert("""
    INSERT INTO student_course (student_id, course_id)
    VALUES (#{studentId}, #{courseId})
""")
    void saveStudentCourse(@Param("studentId") Integer studentId,
                           @Param("courseId") Integer courseId);
    @Delete("""
DELETE FROM student_course WHERE student_id = #{studentId}
""")
    void deleteStudentCourse(Integer studentId);
}
