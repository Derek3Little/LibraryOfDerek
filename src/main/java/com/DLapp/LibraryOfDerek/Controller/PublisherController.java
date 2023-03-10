package com.DLapp.LibraryOfDerek.Controller;

import com.DLapp.LibraryOfDerek.Entity.Publisher;
import com.DLapp.LibraryOfDerek.Service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String findAllPublishers(Model model) {
        model.addAttribute("publishers", publisherService.getAllPublishers());
        return "publishers";
    }

    @GetMapping("/remove-publisher/{id}")
    public String deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return "redirect:/publishers"; // redirect to put user back on publishers page vs remove-publisher/{id} page
    }

    @GetMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable Long id, Model model) {
        model.addAttribute("publisher", publisherService.findPublisherById(id));
        return "update-publisher";
    }

    @PostMapping("/update-publisher/{id}")
    public String saveUpdatePublisher(@PathVariable Long id, Publisher publisher, BindingResult result) {

        if (result.hasErrors()) {
            return "update-publisher";
        }

        publisherService.updatePublisher(publisher);

        return "redirect:/publishers";
    }

    @GetMapping("/add-publisher") // corresponds to name of html file: add-publisher.html
    public String showCreatePublisher(Publisher publisher) {
        return "add-publisher";
    }

    @PostMapping("/save-publisher")
    public String createPublisher(Publisher publisher, BindingResult result) {

        if (result.hasErrors()) {
            return "add-publisher";
        }

        publisherService.createPublisher(publisher);

        return "redirect:/publishers";
    }

}
