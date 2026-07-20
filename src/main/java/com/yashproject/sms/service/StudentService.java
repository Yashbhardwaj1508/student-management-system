package com.yashproject.sms.service;

import com.yashproject.sms.dto.StudentDto;
import jakarta.validation.Valid;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    void createStudent(StudentDto student);

    StudentDto getStudentById(Long studentId);

    void updateStudent(StudentDto studentDto);

    void deleteStudent(Long studentId);
}
