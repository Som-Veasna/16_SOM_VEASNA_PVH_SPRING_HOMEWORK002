package com.sna.homework002.model.response;

import com.sna.homework002.model.request.CourseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseResponse {
    private Integer studentId;
    private String studentName;
    private List<CourseRequest> courses;
}