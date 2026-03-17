package com.sna.homework002.service;

import com.sna.homework002.model.entity.Instructor;
import com.sna.homework002.model.request.InstructorRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstructorService {

    List<Instructor> getAllInstructors();
    Instructor getInstructorById(Integer id);
    Instructor saveInstructor(InstructorRequest instructor);
    Instructor updateInstructor(Integer id, InstructorRequest instructorRequest);
    Instructor deleteInistructorById(Integer id);




}
