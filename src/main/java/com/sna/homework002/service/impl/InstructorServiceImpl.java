package com.sna.homework002.service.impl;

import com.sna.homework002.model.entity.Instructor;
import com.sna.homework002.model.request.InstructorRequest;
import com.sna.homework002.repository.InstructorReository;
import com.sna.homework002.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorReository instructorReository;

    public InstructorServiceImpl(InstructorReository instructorReository) {
        this.instructorReository = instructorReository;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorReository.getAllInstructor();
    }

    @Override
    public Instructor getInstructorById(Integer id) {
        return instructorReository.getInstructorById(id);
    }

    @Override
    public Instructor saveInstructor(InstructorRequest instructor) {
        return instructorReository.saveInstructor(instructor);
    }

    @Override
    public Instructor updateInstructor(Integer id, InstructorRequest instructorRequest) {
        return instructorReository.updateInstructor(id,instructorRequest);
    }

    @Override
    public Instructor deleteInistructorById(Integer id) {
        return instructorReository.deleteInstructor(id);
    }
}
