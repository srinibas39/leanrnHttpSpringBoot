package com.example.httpMethods.controller;

import com.example.httpMethods.model.StudentModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
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
    public ResponseEntity<List<StudentModel>> createStudents(@RequestBody List<StudentModel> students){
        System.out.println(students.get(0));

//        Map<String , Object> maps = new HashMap<>();
//        maps.put("status","success");
//        maps.put("myData",students);
//        maps.put("date",new Date());
//        maps.put("System Infomation",System.getProperties());

//        StudentModel s1 = students.get(0);
//        s1.setAge(22);

        ResponseEntity<List<StudentModel>> response1 = new ResponseEntity<>(students, HttpStatus.CREATED);
        ResponseEntity<List<StudentModel>> response2 = ResponseEntity.status(HttpStatus.CREATED).body(students);
        return response2;

//        return s1;
    }

}
