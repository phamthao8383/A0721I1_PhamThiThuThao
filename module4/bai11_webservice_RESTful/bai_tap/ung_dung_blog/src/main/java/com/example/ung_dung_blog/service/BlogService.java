package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Blog;

import java.util.List;

public interface BlogService {
     List<Blog> findAll();
    void saveBlog(Blog blog);//pt thêm mơi và update(tự hieu gióng id la update)
    void deleteBlog(Long id);
    Blog findBlogById(Long id);
}
