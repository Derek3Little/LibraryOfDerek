package com.DLapp.LibraryOfDerek.Controller;

import com.DLapp.LibraryOfDerek.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    
}
