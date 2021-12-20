package com.saroj.demo.service;

import com.saroj.demo.dto.StudentDTO;

import java.util.List;

public interface StudentService {
StudentDTO addStudent(StudentDTO studentDTO);
StudentDTO findById(int id);
List <StudentDTO> findAll();
StudentDTO updateStudent(StudentDTO studentDTO);
void deleteStudent(int id);
}
