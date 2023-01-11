package com.DLapp.LibraryOfDerek.Controller;

import com.DLapp.LibraryOfDerek.Entity.Category;
import com.DLapp.LibraryOfDerek.Service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String findAllCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("/remove-category/{id}")
    public String deleteCategory(@PathVariable Long id, Model model) {
        categoryService.deleteCategory(id);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "redirect:/categories";
    }

    @GetMapping("/update-category/{id}")
    public String updateCategory(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findCategoryById(id));
        return "update-category";
    }

    @PostMapping("/update-category/{id}")
    public String saveCategory(@PathVariable Long id, Category category, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "update-category";
        }

        categoryService.updateCategory(category);
        model.addAttribute("categories", categoryService.getAllCategories());

        return "redirect:/categories"; // after update, return to categories page
    }

    @GetMapping("/add-category")
    public String showCreateCategory(Category category) {
        return "redirect:/add-category";
    }

    @PostMapping("/save-category")
    public String saveCategory(Category category, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "add-category";
        }

        categoryService.createCategory(category);
        model.addAttribute("categories", categoryService.getAllCategories());

        return "redirect:/categories";
    }

}
