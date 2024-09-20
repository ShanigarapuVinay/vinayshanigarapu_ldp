package com.springdto.service;

import com.springdto.dto.BookDTO;

import java.util.List;

public interface BookService {
    public List<BookDTO> getAllBooks();
    public BookDTO getBookById(Long id);
    public void addBook(BookDTO bookDTO);
}
