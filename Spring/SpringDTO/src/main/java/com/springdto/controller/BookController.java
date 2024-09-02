package com.springdto.controller;

import com.springdto.dto.BookDTO;
import com.springdto.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public List<BookDTO> getAllBooks(){
        return bookService.getAllBooks();
    }

    public BookDTO getBookById(Long id){
        return bookService.getBookById(id);
    }

    public void addBook(BookDTO bookDTO){
        bookService.addBook(bookDTO);
    }

}
