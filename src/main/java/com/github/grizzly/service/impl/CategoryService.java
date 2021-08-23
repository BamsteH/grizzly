package com.github.grizzly.service.impl;

import com.github.grizzly.entity.Category;
import com.github.grizzly.repository.CategoryRepository;
import com.github.grizzly.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Optional<Category> findCategoryById(long id) {
        return categoryRepository.findCategoryById(id);
    }

    @Override
    public List<Category> findCategoriesByParentId(Long parentId) {
        return categoryRepository.findCategoriesByParentId(parentId);
    }

    @Override
    public List<Category> findCategoriesByParentIdIsNull() {
        return categoryRepository.findCategoriesByParentIdIsNull();
    }

    @Override
    public void save(Category category) {
      categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return null;
    }
}
