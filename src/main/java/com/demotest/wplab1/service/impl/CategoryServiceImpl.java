package com.demotest.wplab1.service.impl;

import com.demotest.wplab1.model.Category;
import com.demotest.wplab1.repository.jpa.CategoryRepository;
import com.demotest.wplab1.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAllCategories() {
        return this.categoryRepository.findAll();
    }
}
