package com.example.blog_manager.service.impl;

import com.example.blog_manager.model.Blog;
import com.example.blog_manager.repository.BlogRepository;
import com.example.blog_manager.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class BlogServiceImp implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);

    }

    @Override
    public void deleteBlog(Long id) {
       blogRepository.deleteById(id);
    }

    @Override
    public Blog findBlogById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }
}
