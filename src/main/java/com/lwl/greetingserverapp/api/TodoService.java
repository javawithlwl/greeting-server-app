package com.lwl.greetingserverapp.api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class TodoService {
  private List<Todo> todoList;

  public TodoService() {
    todoList = new ArrayList<>();
  }

  public Todo addTodo(Todo todo) {
    todo.setId(ThreadLocalRandom.current().nextInt(1001, 10000));
    todoList.add(todo);
    return todo;
  }

  public List<Todo> getTodoList() {
    return todoList;
  }

  public Todo updateTodo(Todo todo) {
    Todo updatedTodo = null;
    for (Todo t : todoList) {
      if (t.getId() == todo.getId()) {
        t.setTitle(todo.getTitle());
        updatedTodo = t;
        break;
      }
    }
    return updatedTodo;
  }
  public boolean deleteTodo(int id){

    int index = getIndex(id);
    if(index!=-1){
        todoList.remove(index);
        return  true;
    }
    return false;
  }
  public Todo getTodo(int id){
      int index = getIndex(id);
      return todoList.get(index);
  }
  private int getIndex(int id) {
    for(int i=0;i<todoList.size();i++){
        if(todoList.get(i).getId() == id){
          return i;
        }
    }

    return -1;
  }
}
