package com.example.libraryProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    MemberRepository memberRepository;



    public Book saveBook(String isbn, String bookName, String author, double price ){
        Book book= new Book(isbn, bookName, author, price);
        bookRepository.save(book);
        return book;
    }

    public String deleteBookByName(String bookName){
         Book book= bookRepository.findBookByBookName(bookName);
         bookRepository.delete(book);
         return book + "  book deleted! ";

    }

    public String deleteBookById(int bookId){
        bookRepository.deleteById(bookId);
        return " book deleted! ";
    }

    public List<Book> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        return books;

    }

    public Book getBookById (int bookId){
        Book book = bookRepository.findById(bookId).orElse(null);
        return book;

    }


    public List<Book> searchBooks(String bookName, String author, String isbn, double price){
        return bookRepository.findBookByBookNameAndAuthorAndIsbnAndPrice(bookName, author,isbn,price);

    }


    public Book editBook (Book updateBook){
        Book existingBook = bookRepository.findBookByBookName(updateBook.getBookName());
        existingBook.setIsbn(updateBook.getIsbn());
        existingBook.setBookName(updateBook.getBookName());
        existingBook.setAuthor(updateBook.getAuthor());
        existingBook.setPrice(updateBook.getPrice());
        bookRepository.save(existingBook);
        return existingBook;
    }

    public String borrowBook(int id, int bookId){
        Member member= memberRepository.findById(id).orElse(null);
        Book book= bookRepository.findById(bookId).orElse(null);
        member.addBookToBooks(book);
        book.setBorrowed(true);
        bookRepository.save(book);
        memberRepository.save(member);
        return "The book" + book + "add to member" + member;

    }

    public Book returnBook (int bookId){
        Book book = getBookById(bookId);
        if (book.isBorrowed()){
            book.setBorrowed(false);
            return bookRepository.save(book);
        } else System.out.println("This book is not borrowed!!!") ;
        return book;
    }


    }
