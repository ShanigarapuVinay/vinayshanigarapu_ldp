package com.springdto.repository;

import com.springdto.model.Book;

import java.util.List;

public interface BookRepository {

    public List<Book> findAll();

    public Book findByID(Long id);

    public void save(Book book);
}
