package com.example.httpMethods.controller;


import com.example.httpMethods.model.Todo;
import com.example.httpMethods.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class TodoController {


    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    TodoService todoService ;

    //create todos
    @PostMapping("/todos")
    public ResponseEntity<List<Todo>> createTodos(@RequestBody Todo todo){
        logger.info("Create todo");
        List<Todo> todos =todoService.create(todo);

        ResponseEntity<List<Todo>> response = new ResponseEntity<>(todos, HttpStatus.CREATED);
        return response;

    }

    //get all todos

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodos(){
        logger.info("todo created");
        List<Todo> todos = todoService.getTodos();
        ResponseEntity<List<Todo>> response = new ResponseEntity<>(todos,HttpStatus.OK);
        return response;
    }


    //get todod using id
    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable("id") int id){
        logger.info("get todo using id");
        Todo todo = todoService.getTodo(id);
        return new ResponseEntity<>(todo,HttpStatus.OK);
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<List<Todo>> updateTodoHandler(@RequestBody Todo todo,@PathVariable("id") int id){
        logger.info("update todo using id");
        List<Todo> todos = todoService.updateTodo(id,todo);
        return new ResponseEntity<>(todos,HttpStatus.OK);

    }
    @DeleteMapping("/todo/{id}")
    public ResponseEntity<List<Todo>> deleteTodoHandler(@PathVariable int id){
       logger.info("delete todo using id");
       List<Todo> todos = todoService.deleteTodo(id);
       return new ResponseEntity<>(todos,HttpStatus.OK);
    }


}
