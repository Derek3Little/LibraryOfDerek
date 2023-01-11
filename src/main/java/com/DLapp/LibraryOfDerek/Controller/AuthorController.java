package com.DLapp.LibraryOfDerek.Controller;

import com.DLapp.LibraryOfDerek.Entity.Author;
import com.DLapp.LibraryOfDerek.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String findAllAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }

    @GetMapping("/remove-author/{id}")
    public String removeAuthor(@PathVariable Long id, Model model) {
        authorService.deleteAuthor(id); // delete the author by id
        model.addAttribute("authors", authorService.getAllAuthors()); // repopulate authors
        return "redirect:/authors"; // redirect to get user off remove-author page
    }

    @GetMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorService.findAuthorById(id));
        return "update-author";
    }

    @PostMapping("/update-author/{id}")
    public String saveUpdateAuthor(@PathVariable Long id, Author author, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "update-author";
        }

        authorService.updateAuthor(author); // save update
        // model.addAttribute("authors", authorService.getAllAuthors()); SUPERFLUOUS WITH REDIRECT

        return "redirect:/authors"; // redirect off of update-author page, back to authors
    }
}
