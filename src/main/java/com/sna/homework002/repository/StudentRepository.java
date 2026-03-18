package com.sna.homework002.repository;

import com.sna.homework002.model.entity.Student;
import com.sna.homework002.model.request.StudentRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Results(id = "studentMapper",value = {
            @Result(property = "studentId",column = "student_id"),
            @Result(property = "studentName",column = "student_name"),
            @Result(property = "phoneNumber",column = "phone_number"),
            @Result(property = "course",column = "student_id",
                    many = @Many(select = "com.sna.homework002.repository.CourseRepository.getAllCourseByStudentId")
            )
    })
    @Select("""
     select * from students
            offset #{size} *(#{page}-1)
       limit #{size}\s
     ;
""")
    List<Student> getAllStudent(Integer size,Integer page);
    @Select("""
select * from students where student_id = #{studentId}; 
""")
    @ResultMap("studentMapper")
    Student getStudentById(Integer studentId);

    @Select("""
    INSERT INTO students (student_name, email, phone_number)
    VALUES (#{request.name}, #{request.email}, #{request.phoneNumber})
    RETURNING *;
""")
    @ResultMap("studentMapper")
    Student saveStudent(@Param("request") StudentRequest studentRequest);


    @Delete("""
DELETE FROM students WHERE student_id = #{studentId};
""")
    void deleteStudentByID(Integer studentId);
    @Select("""
  update students set student_name = #{studentRequest.name},email=#{studentRequest.email},phone_number=#{studentRequest.phoneNumber} where student_id = #{studentId} returning *;
""")
    @ResultMap("studentMapper")
    Student updateStudent(@Param("studentId") Integer studentId,@Param("studentRequest") StudentRequest studentRequest);

}
