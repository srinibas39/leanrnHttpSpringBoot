package com.example.httpMethods.service;


import com.example.httpMethods.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TodoService {

    List<Todo> todos = new ArrayList<>();

    Random random = new Random();

    public List<Todo> create(Todo todo){
        int rand = random.nextInt(9999999);
        todo.setId(rand);
        todos.add(todo);
        return todos;
    }
}
