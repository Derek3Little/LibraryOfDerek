package com.DLapp.LibraryOfDerek.Controller;

import com.DLapp.LibraryOfDerek.Entity.Book;
import com.DLapp.LibraryOfDerek.Service.AuthorService;
import com.DLapp.LibraryOfDerek.Service.BookService;
import com.DLapp.LibraryOfDerek.Service.CategoryService;
import com.DLapp.LibraryOfDerek.Service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public String findAllBooks(Model model) {
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "books"; // name of html file returned
    }

    @GetMapping("/book/{id}")
    public String findBook(@PathVariable Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "list-book";
    }

    @GetMapping("remove-book/{id}")
    public String deleteBook(@PathVariable Long id, Model model) {
        bookService.deleteBook(id);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/books"; // returning the book list reflecting deleted book
    }

    @GetMapping("/update-book/{id}")
    public String updateBook(@PathVariable Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("publishers", publisherService.getAllPublishers());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "update-book";
    }

    @PostMapping("/save-update/{id}") // 'post' mapping for sending information to update!
    public String updateBook(@PathVariable Long id, Book book, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "update-book";
        }

        bookService.updateBook(book);
        model.addAttribute("book", bookService.findAllBooks());

        return "redirect:/books"; // 'redirect:' will send user to /books
    }
}
