package com.sna.homework002.controller;

import com.sna.homework002.model.entity.Instructor;
import com.sna.homework002.model.request.InstructorRequest;
import com.sna.homework002.model.response.ApiResponse;
import com.sna.homework002.service.InstructorService;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/instructor")
public class InstructorController {
private  final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @GetMapping
    public ResponseEntity<?> getAllInstructors() {
        ApiResponse<?> response=ApiResponse.<List<Instructor>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Success")
                .payload(instructorService.getAllInstructors())
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{instructor-id}")
    public ResponseEntity<?> getInstructorById(@PathVariable("instructor-id") Integer instructorId) {
        ApiResponse<?> response=ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("get Instructor success")
                .payload(instructorService.getInstructorById(instructorId))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<?> saveInstructor(@RequestBody InstructorRequest instructorRequest){
        ApiResponse<Instructor> response=ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Save Instructor success")
                .payload(instructorService.saveInstructor(instructorRequest))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{instructor-id}")
    public ResponseEntity<?> updateInstructorByID(@PathVariable("instructor-id") Integer id, @RequestBody InstructorRequest instructorRequest) {
        ApiResponse<Instructor> response=ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("update Instructor success")
                .payload(instructorService.updateInstructor(id, instructorRequest))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{instructor-id}")
    public ResponseEntity<?> deleteInstructorByID(@PathVariable("instructor-id") Integer id) {
        instructorService.deleteInistructorById(id);
        ApiResponse<?> response=ApiResponse.<String>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("delete Instructor success")
                .payload("delete Instructor success")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }



}