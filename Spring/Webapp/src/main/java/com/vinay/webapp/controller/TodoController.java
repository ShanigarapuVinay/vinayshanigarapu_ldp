package com.vinay.webapp.controller;

import com.vinay.webapp.entity.Todo;
import com.vinay.webapp.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/list-todos")
    public String listTodos(Model model){
        List<Todo> todoList = todoService.getTodos();
        model.addAttribute("todos", todoList);
        return "listTodos";
    }

    @GetMapping("/add-todo")
    public String showTodoForm(Model model){
        Todo todo = new Todo(LocalDate.now().plusYears(1));
        model.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping("/add-todo")
    public String addNewTodo(@Valid @ModelAttribute("todo") Todo todo, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "todo";
        todoService.save(todo);
        return "redirect:list-todos";
    }

    @GetMapping("/update-todo")
    public String showUpdateTodo(@RequestParam int id, Model model){
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping("/update-todo")
    public String updateTodo(@Valid @ModelAttribute("todo") Todo todo, BindingResult bindingResult){
        System.out.println(bindingResult + " " + bindingResult.hasErrors());
        if(bindingResult.hasErrors())
            return "todo";
        todoService.save(todo);
        return "redirect:list-todos";
    }

    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoService.deleteById(id);
        return "redirect:list-todos";
    }
}
