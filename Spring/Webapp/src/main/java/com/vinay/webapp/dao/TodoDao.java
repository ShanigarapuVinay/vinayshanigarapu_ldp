package com.vinay.webapp.dao;

import com.vinay.webapp.entity.Todo;

import java.util.List;

public interface TodoDao {
    public List<Todo> getTodos();

    public void save(Todo todo);

    public Todo getTodoById(int id);

    public void deleteById(int id);
}
