package com.example.blog_manager.service;

import com.example.blog_manager.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    void saveBlog(Blog blog);//pt thêm mơi và update(tự hieu gióng id la update)
    void deleteBlog(Long id);
    Blog findBlogById(Long id);
}
