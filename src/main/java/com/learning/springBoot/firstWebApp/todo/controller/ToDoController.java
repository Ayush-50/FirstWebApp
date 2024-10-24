package com.learning.springBoot.firstWebApp.todo.controller;


import com.learning.springBoot.firstWebApp.todo.data.Todo;
import com.learning.springBoot.firstWebApp.todo.data.TodoList;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;


@Controller
@SessionAttributes("name")
public class ToDoController {

    @Autowired
    private TodoList list;

    @RequestMapping("/list-todos")
    public String listView(ModelMap map) {

        String username = getLoggedInUserName();
        List<Todo> todos = list.findByUsername(username);
        map.put("toDoList", todos);
        map.addAttribute("todos", todos);
        return "list-todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String addTodo(ModelMap map) {
        Todo todo = new Todo(0, "Name of your task here", getLoggedInUserName(), "More details here", LocalDate.now().plusYears(1), false);
        map.addAttribute("Success_Message_Present", false);
        map.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodoSuccess(ModelMap map, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        list.add(todo.getName(), getLoggedInUserName(), todo.getDescription());
        map.addAttribute("Success_Message", "ToDoAdded Successfully, Click To View");
        map.addAttribute("Success_Message_Present", true);
        return "redirect:list-todos";
    }

    private static String getLoggedInUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        list.deleteTodo(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "modify-todo", method = RequestMethod.GET)
    public String modifyTodo(@RequestParam int id, ModelMap map) {

        Todo todo = list.getTodoById(id);
        map.addAttribute("todo", todo);
        map.addAttribute("id",id);
        return "todo";
    }

    @RequestMapping(value = "modify-todo", method = RequestMethod.POST)
    public String modifyTodoPost(@RequestParam int id, ModelMap map, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }
        Todo todo1 = list.getTodoById(id);
        todo1.setName(todo.getName());
        todo1.setDescription(todo.getDescription());
        todo1.setTargetDate(todo.getTargetDate());
        return "redirect:list-todos";
    }

}
