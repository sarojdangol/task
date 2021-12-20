package com.saroj.demo.service.impl;

import com.saroj.demo.dto.StudentDTO;
import com.saroj.demo.model.Student;
import com.saroj.demo.repository.StudentRepository;
import com.saroj.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student= new Student(studentDTO);
        Student savedStudent= studentRepository.save(student);
        StudentDTO savedStudentDTO= new StudentDTO(savedStudent);
        return savedStudentDTO;
    }

    @Override
    public StudentDTO findById(int id) {
       Optional<Student> studentOptional= studentRepository.findById(id);
//       StudentDTO studentDTO=null;
//       if(studentOptional.isPresent()){
//           studentDTO= new StudentDTO(studentOptional.get());
//
//       }
        Student student = studentOptional.orElseThrow(()-> new RuntimeException("User with given id not found"));
        StudentDTO studentDTO=new StudentDTO((student));
        return studentDTO;
    }

    @Override
    public List<StudentDTO> findAll() {
List <Student> students = studentRepository.findAll();
List <StudentDTO> studentDTOS= new ArrayList<>();
for(Student student: students) {
    StudentDTO studentDTO = new StudentDTO(student);
    studentDTOS.add(studentDTO);
}
return studentDTOS;
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public void deleteStudent(int id) {
        
    }
}
