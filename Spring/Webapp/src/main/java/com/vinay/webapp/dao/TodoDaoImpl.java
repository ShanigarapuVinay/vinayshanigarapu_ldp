package com.vinay.webapp.dao;

import com.vinay.webapp.entity.Todo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TodoDaoImpl implements TodoDao{

    private SessionFactory sessionFactory;

    public TodoDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Todo> getTodos() {
        Session session = sessionFactory.getCurrentSession();

        Query<Todo> query = session.createQuery("from Todo order by target_date", Todo.class);
        List<Todo> todos = query.getResultList();

        return todos;
    }

    @Override
    public void save(Todo todo) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(todo);
    }

    @Override
    public Todo getTodoById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Todo.class, id);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Todo where id=:todoId");
        query.setParameter("todoId", id);

        query.executeUpdate();
    }
}
