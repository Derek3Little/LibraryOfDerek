package com.DLapp.LibraryOfDerek.Service;

import com.DLapp.LibraryOfDerek.Entity.Category;
import com.DLapp.LibraryOfDerek.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category not found!")); // checking if category exists
        return category;
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        Category category = findCategoryById(id); // find..
        categoryRepository.deleteById(category.getCategoryId()); // ..then delete
    }
}
