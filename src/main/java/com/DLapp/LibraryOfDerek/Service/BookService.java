package com.DLapp.LibraryOfDerek.Service;

import com.DLapp.LibraryOfDerek.Entity.Book;
import com.DLapp.LibraryOfDerek.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found!")); // in case book not found
        return book;
    }

    public void createBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Book book = findBookById(id); // book must first be found
        bookRepository.deleteById(book.getBookId()); // getBookId getter provided by lombok!
    }
}
