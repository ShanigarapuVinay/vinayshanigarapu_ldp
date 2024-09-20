package com.springdto.service;

import com.springdto.dto.BookDTO;
import com.springdto.model.Book;
import com.springdto.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        logger.info("GetAllBooks is executed successfully..");
        return books.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long id) {
        logger.trace("GetBookById traced...");
        Book book = bookRepository.findByID(id);
        return book != null ? convertToDTO(book) : null;
    }

    @Override
    public void addBook(BookDTO bookDTO) {
        Book book = convertToEntity(bookDTO);
        bookRepository.save(book);
    }

    public BookDTO convertToDTO(Book book){
        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor());
    }

    public Book convertToEntity(BookDTO bookDTO){
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublishDate(new Date());
        return book;
    }
}
