package com.vinay.webapp.service;

import com.vinay.webapp.entity.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getTodos();

    public void save(Todo todo);

    public Todo getTodoById(int id);
    public void deleteById(int id);
}
