package com.example.libraryProject;

import com.example.libraryProject.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book, Integer> {

    Book findBookByBookName (String bookName);

    List<Book> findBookByBookNameAndAuthorAndIsbnAndPrice (String bookName, String author, String isbn, double price);



}
