package com.example.httpMethods.service;


import com.example.httpMethods.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    public List<Todo> getTodos() {
        return todos;
    }

    public Todo getTodo(int id){
        return todos.stream().filter(todo -> todo.getId() == id).findAny().get();
    }

    public List<Todo> updateTodo(int id , Todo newTodo){
        this.todos=todos.stream().map(todo -> {
            if(todo.getId() == id){
                todo.setContent(newTodo.getContent());
                todo.setStatus(newTodo.getStatus());;
                todo.setTitle(newTodo.getTitle());
                todo.setId(random.nextInt(999999));
                todo.setUpdatedAt(LocalDateTime.now());
            }

                return todo;

        }).collect(Collectors.toList());
        return this.todos;

    }

    public List<Todo> deleteTodo(int id){
        this.todos=this.todos.stream().filter(todo -> todo.getId() != id).collect(Collectors.toList());
        return this.todos;
    }
}
