package com.sna.homework002.controller;

import com.sna.homework002.model.entity.Instructor;
import com.sna.homework002.model.request.InstructorRequest;
import com.sna.homework002.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructor")
public class InstructorController {
private  final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }
    @GetMapping("/{instructor-id}")
    public Instructor getInstructorById(@PathVariable("instructor-id") Integer instructorId) {
        return instructorService.getInstructorById(instructorId);
    }
    @PostMapping
    public Instructor saveInstructor(@RequestBody InstructorRequest instructorRequest){
        return instructorService.saveInstructor(instructorRequest);
    }
    @PutMapping("/{instructor-id}")
    public Instructor updateInstructorByID(@PathVariable("instructor-id") Integer id, @RequestBody InstructorRequest instructorRequest) {
        return instructorService.updateInstructor(id, instructorRequest);
    }
    @DeleteMapping("/{instructor-id}")
    public Instructor deleteInstructorByID(@PathVariable("instructor-id") Integer id) {
        return instructorService.deleteInistructorById(id);
    }



}