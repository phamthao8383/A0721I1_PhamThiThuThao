package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    void saveCategory(Category category);//pt thêm mơi và update(tự hieu gióng id la update)
    void deleteCategory(Long id);
    Category findCategoryById(Long id);
}
