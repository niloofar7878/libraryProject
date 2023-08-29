package com.example.libraryProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping
    public Book saveBook(@RequestParam String isbn, @RequestParam String bookName,
                         @RequestParam String author, @RequestParam double price){
        return bookService.saveBook(isbn, bookName,author, price);

    }

    @PutMapping
    public Book editBook(@RequestParam Book book){

        return bookService.editBook(book);
    }

    @GetMapping(value = "/borrowBook")
    public String borrowBook(@RequestParam int id,@RequestParam int bookId){
        bookService.borrowBook(id,bookId);
        return "Book is borrowed";
    }

    @GetMapping
    public List<Book> showAllBooks (){
        return bookService.getAllBooks();
    }

    @DeleteMapping
    public String deleteBookByName (@RequestParam String bookName){
        return bookService.deleteBookByName(bookName);
    }

    @GetMapping(value = "/searchBooks")
    public List<Book> searchBooks(@RequestParam(value = "bookName", required = false) String bookName, @RequestParam(value = "author", required = false) String author,
                                  @RequestParam(value = "isbn", required = false) String isbn,@RequestParam(value = "price", required = false) double price){
        return bookService.searchBooks(bookName, author, isbn, price);
    }

    @GetMapping(value = "/id")
    public Book getBookById( int bookId){
        return bookService.getBookById(bookId);
    }

    @PutMapping(value = "/bookId/return")
    public Book returnBook(@RequestParam int bookId){
        return bookService.returnBook(bookId);
    }





}
