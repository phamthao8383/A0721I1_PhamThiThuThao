package com.example.validate_form_dk.reposition;

import com.example.validate_form_dk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposition extends JpaRepository<User,Long> {
}
