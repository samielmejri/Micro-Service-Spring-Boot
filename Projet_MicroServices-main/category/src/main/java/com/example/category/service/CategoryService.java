package com.example.category.service;

import com.example.category.entity.Category;
import com.example.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }
    public Category updateCategory(int id, Category newCategory) {
        if (categoryRepository.findById(id).isPresent()) {
            Category existingCategory = categoryRepository.findById(id).get();
            existingCategory.setNom(newCategory.getNom());
            existingCategory.setDescription(newCategory.getDescription());
            existingCategory.setType(newCategory.getType());

            return categoryRepository.save(existingCategory);
        } else
            return null;
    }
    public String deleteCategory(int id) {
        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
            return "category supprimé";
        } else
            return "category non supprimé";
    }
}
