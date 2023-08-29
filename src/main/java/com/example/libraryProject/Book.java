package com.example.libraryProject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private int bookId;
    private String isbn;
    private String bookName;
    private String author;
    private double price;

    @Column(nullable = true)
    private boolean borrowed= false;




    public Book(String isbn, String bookName, String author, double price) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

}
