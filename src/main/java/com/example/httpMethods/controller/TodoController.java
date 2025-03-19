package com.example.httpMethods.controller;


import com.example.httpMethods.model.Todo;
import com.example.httpMethods.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class TodoController {


    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    TodoService todoService ;

    @PostMapping("/todos")
    public List<Todo> createTodos(@RequestBody Todo todo){
        logger.info("Create todo");
        List<Todo> todos =todoService.create(todo);

        return todos;


    }
}
