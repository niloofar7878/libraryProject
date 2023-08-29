package com.example.libraryProject;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String family;
    private int cardId;
    private String userName;
    private String password;

    @OneToMany
    private List<Book> books;

    public Member(String name, String family, int cardId, String userName, String password) {
        this.name = name;
        this.family = family;
        this.cardId = cardId;
        this.userName = userName;
        this.password = password;
    }

    public void addBookToBooks(Book book){this.books.add(book);}

}
