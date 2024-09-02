package com.springdto.model;

import java.util.Date;

public class Book {
    private Long id;
    private String title;
    private String author;
    private Date publishDate;

    public Book() {
    }

    public Book(Long id, String title, String author, Date publishDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
