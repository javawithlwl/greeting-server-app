package com.lwl.greetingserverapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
  @Autowired
  private TodoService todoService;

  @PostMapping("/add-todo")
  public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
    Todo savedTodo = todoService.addTodo(todo);
    return ResponseEntity.ok(savedTodo);
  }

  @PutMapping("/update-todo")
  public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
    Todo updateTodo = todoService.updateTodo(todo);
    return ResponseEntity.ok(updateTodo);
  }
  @GetMapping("/list")
  public ResponseEntity<List<Todo>> getTodos() {
    List<Todo> list = todoService.getTodoList();
    return ResponseEntity.ok(list);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Todo> getTodo(@PathVariable("id")int id){
    Todo todo = todoService.getTodo(id);
    return ResponseEntity.ok(todo);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteTodo(@PathVariable("id")int id){
    boolean isDeleted= todoService.deleteTodo(id);
    return ResponseEntity.ok(isDeleted?"Deleted":"Something went wrong");
  }
}
