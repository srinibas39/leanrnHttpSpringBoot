package com.example.httpMethods.controller;

import com.example.httpMethods.model.StudentModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentController {

    @PostMapping("/createStudent")
    public String createStudent(@RequestBody Map<String,Object> map){
        return "student created";
    }

    @PostMapping("/createStudent2")

    public StudentModel createStudent2(@RequestBody StudentModel student){
          System.out.println(student);

          String name = student.getName();

          System.out.println(name);

          return student;
    }

    @PostMapping("/createStudents")
    public List<StudentModel> createStudents(@RequestBody List<StudentModel> students){
        System.out.println(students);

        return students;
    }

}
