package com.vinay.webapp.service;

import com.vinay.webapp.dao.TodoDao;
import com.vinay.webapp.entity.Todo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    private TodoDao todoDao;

    public TodoServiceImpl(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @Override
    @Transactional
    public List<Todo> getTodos() {
        return todoDao.getTodos();
    }

    @Override
    @Transactional
    public void save(Todo todo) {
        todoDao.save(todo);
    }

    @Override
    @Transactional
    public Todo getTodoById(int id) {
        return todoDao.getTodoById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        todoDao.deleteById(id);
    }
}
