package com.springdto.application;

import com.springdto.controller.BookController;
import com.springdto.dto.BookDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("com.springdto")
public class SpringDtoApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDtoApplication.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        BookController bookController = context.getBean(BookController.class);

        // Add a Book
        BookDTO newBook = new BookDTO();
        newBook.setId(1L);
        newBook.setTitle("Song of Ice & Fire");
        newBook.setAuthor("George R. R. Martin");
        bookController.addBook(newBook);

        BookDTO newBook2 = new BookDTO();
        newBook2.setId(2L);
        newBook2.setTitle("Harry Potter and the Goblet of Fire");
        newBook2.setAuthor("J. K. Rowling");
        bookController.addBook(newBook2);

        // Get all books
        List<BookDTO> allBooks = bookController.getAllBooks();
        for (BookDTO book : allBooks)
            System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor());

        // Get a book by ID
        BookDTO book = bookController.getBookById(1L);
        if (book != null)
            System.out.println("Found book: " + book.getTitle() + " by " + book.getAuthor());
        }
}
