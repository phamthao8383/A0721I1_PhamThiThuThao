package com.example.demo3.reposition;

import com.example.demo3.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CategoryReposition extends JpaRepository<Category, String> {
    Category findById(long id);
    Page<Category> findByNameLike(String keywords, Pageable pageable);
    Category deleteById(long id);

}