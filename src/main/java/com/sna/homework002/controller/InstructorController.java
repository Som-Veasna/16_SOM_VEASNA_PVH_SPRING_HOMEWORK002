package com.sna.homework002.controller;

import com.sna.homework002.model.entity.Instructor;
import com.sna.homework002.model.request.InstructorRequest;
import com.sna.homework002.model.response.ApiResponse;
import com.sna.homework002.service.InstructorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructor")
public class InstructorController {
private  final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @Operation(summary = "Get all instructor")
    @GetMapping
    public ResponseEntity<?> getAllInstructors(@RequestParam(defaultValue = "10") Integer size , @RequestParam(defaultValue = "1")Integer page) {
        ApiResponse<?> response=ApiResponse.<List<Instructor>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Success")
                .payload(instructorService.getAllInstructors(size,page))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Get instructor by id")
    @GetMapping("/{instructor-id}")
    public ResponseEntity<?> getInstructorById(@PathVariable("instructor-id") Integer instructorId) {
        Instructor instructor = instructorService.getInstructorById(instructorId);
        if (instructor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.<Void>builder()
                            .success(false)
                            .status(HttpStatus.NOT_FOUND.value())
                            .message("Instructor Not Found with id: " + instructorId)
                            .timestamp(Instant.now())
                            .build());
        }
        return ResponseEntity.ok(ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Get Instructor Successfully")
                .payload(instructor)
                .timestamp(Instant.now())
                .build());
    }
    @Operation(summary = "Create instructor")
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
    @Operation(summary = "Update instructor by id")
    @PutMapping("/{instructor-id}")
    public ResponseEntity<?> updateInstructorByID(@PathVariable("instructor-id") Integer id, @RequestBody InstructorRequest instructorRequest) {
        Instructor instructor=instructorService.getInstructorById(id);
        if(instructor==null){
            return getInstructorById(id);
        }
        ApiResponse<Instructor> response=ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("update Instructor success")
                .payload(instructorService.updateInstructor(id, instructorRequest))
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Delete instructor by id")
    @DeleteMapping("/{instructor-id}")
    public ResponseEntity<?> deleteInstructorByID(@PathVariable("instructor-id") Integer id) {
        Instructor instructor=instructorService.getInstructorById(id);
        if(instructor==null){
            return getInstructorById(id);
        }
        instructorService.deleteInistructorById(id);
        ApiResponse<?> response=ApiResponse.<String>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("delete Instructor success")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
}

