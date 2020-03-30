package com.amat.demo.rest;

import com.amat.demo.dto.Account;
import com.amat.demo.dto.Bookmark;
import com.amat.demo.repository.AccountRepository;
import com.amat.demo.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AccountController {
    private AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping("/account")
    public ResponseEntity<Account> createBookmark(@RequestBody Account account) {
        try {
            Account account1 = new Account("abc", "123");
            Account account2 = new Account("user", "user123");
            Account account3 = new Account("admin", "admin");
            Account _account = accountRepository
                    .save(new Account(account2.getUsername(), account2.getPassword()));
            return new ResponseEntity<>(_account, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
