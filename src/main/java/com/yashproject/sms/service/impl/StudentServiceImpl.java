package com.yashproject.sms.service.impl;

import com.yashproject.sms.dto.StudentDto;
import com.yashproject.sms.entity.Student;
import com.yashproject.sms.mapper.StudentMapper;
import com.yashproject.sms.repository.StudentRepository;
import com.yashproject.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;


    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos =students.stream()
                .map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toUnmodifiableList());
        return studentDtos;
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);

    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        StudentDto studentDto = StudentMapper.mapToStudentDto(student);
        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        studentRepository.save(StudentMapper.mapToStudent(studentDto));

    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);

    }
}
