package com.springdto.repository;

import com.springdto.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepositoryImpl implements BookRepository{

    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findByID(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Book book) {
        books.add(book);
    }
}
