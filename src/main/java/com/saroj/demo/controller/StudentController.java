package com.saroj.demo.controller;

import com.saroj.demo.dto.StudentDTO;
import com.saroj.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO){
        return studentService.addStudent(studentDTO);

    }

    @GetMapping
    public List<StudentDTO> getAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable int id){
        return studentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "User of id :"+id+"deleted";
    }

    @PutMapping
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(studentDTO);
    }
}
