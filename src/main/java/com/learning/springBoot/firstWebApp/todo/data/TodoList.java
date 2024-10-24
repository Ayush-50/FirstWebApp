package com.learning.springBoot.firstWebApp.todo.data;

import com.learning.springBoot.firstWebApp.todo.data.Todo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;


@Component
public class TodoList {

    private static List<Todo> todoList = new ArrayList<>();
    static int todosCount = 0;

    static{
        todoList.add(new Todo(++todosCount,"learn spring", "ayush", "Learn Spring from in28minutes", LocalDate.now().plusYears(1), false));
        todoList.add(new Todo(++todosCount,"learn spring boot", "ayush", "Learn Spring Boot from in28minutes", LocalDate.now().plusYears(1), false));
        todoList.add(new Todo(++todosCount,"learn aws", "ayush", "Learn AWS from in28minutes", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> add(Todo todo){
        todoList.add(todo);
        return  todoList;
    }

    public List<Todo> add(String name, String username, String description){
        Todo todo = new Todo(++todosCount,name,username,description,LocalDate.now().plusYears(1),false);
        todoList.add(todo);
        return  todoList;
    }

    public void deleteTodo(int id) {
        Todo todo1 = new Todo();
        for (Todo todo: todoList) {
            if(todo.id == id){
                todo1 = todo; break;
            }
        }
        if(todo1.id != 0){
        remove(todo1);}

    }

    public Todo getTodoById(int id) {
        Todo todo1 = new Todo();
        for (Todo todo: todoList) {
            if(todo.id == id){
                todo1 = todo; break;
            }
        }
        return todo1;

    }


    public static List<Todo> findAll(){
        return todoList;
    }

    public  List<Todo> remove(Todo todo){
        todoList.remove(todo);
        return todoList;
    }

    public  List<Todo> findByUsername(String username){
        List<Todo> list = new ArrayList<Todo>();
        for(Todo t:todoList){
            if(t.getUsername().equals(username)){
                list.add(t);
            }
        }
        return list;
    }




}
