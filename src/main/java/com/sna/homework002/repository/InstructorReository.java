package com.sna.homework002.repository;

import com.sna.homework002.model.entity.Instructor;
import com.sna.homework002.model.entity.Student;
import com.sna.homework002.model.request.InstructorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorReository {
    @Results(id = "InstructorMapper",value = {
            @Result(property = "instructorId",column = "instructor_id"),
            @Result(property = "instructorName",column = "instructor_name")
    })
    @Select("""
select * from instructors  order by instructor_id asc
       offset #{size} *(#{page}-1)
  limit #{size}\s
;
""")
    List<Instructor> getAllInstructor(Integer size, Integer page);

    @Select("""
select * from instructors where instructor_id = #{id};
""")
    @ResultMap("InstructorMapper")
    Instructor getInstructorById(@Param("id") Integer id);

    @Select("""
        insert into instructors(instructor_name,email)
        values(#{request.instructorName},#{request.email}) returning *;
    """)
    @ResultMap("InstructorMapper")
    Instructor saveInstructor(@Param("request") InstructorRequest instructor);

    @Select("""
        update instructors
        set instructor_name = #{request.instructorName},
            email = #{request.email}
        where instructor_id = #{id} returning *;
    """)
    @ResultMap("InstructorMapper")
    Instructor updateInstructor(Integer id, @Param("request") InstructorRequest instructorRequest);

    @Delete("""
        delete from instructors
        where instructor_id = #{id} returning *;
    """)
    void deleteInstructor(Integer id);

}
