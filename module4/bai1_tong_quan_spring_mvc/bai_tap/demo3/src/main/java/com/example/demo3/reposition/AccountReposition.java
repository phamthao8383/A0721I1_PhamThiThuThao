package com.example.demo3.reposition;

import com.example.demo3.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface AccountReposition extends JpaRepository<Account,String> {
    Account deleteById(long id);
    Account findById(long id);
    Account findByEmail(String email);
    Account findAccountByUsername(String username);
    List<Account> findAllById(long id);
    Page<Account> findByUsernameLike(String keywords, Pageable pageable);
}

