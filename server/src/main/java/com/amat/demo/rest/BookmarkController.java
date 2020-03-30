package com.amat.demo.rest;

import com.amat.demo.dto.Account;
import com.amat.demo.dto.Bookmark;
import com.amat.demo.dto.Owner;
import com.amat.demo.dto.Repository;
import com.amat.demo.repository.AccountRepository;
import com.amat.demo.repository.BookmarkRepository;
import com.amat.demo.entity.BookmarkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BookmarkController {
    private BookmarkRepository bookmarkRepository;
    private AccountRepository accountRepository;

    @Autowired
    public BookmarkController(BookmarkRepository bookmarkRepository, AccountRepository accountRepository) {
        this.bookmarkRepository = bookmarkRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/bookmarks")
    public List<Bookmark> findBookmarksByUsername(@RequestParam(name = "q") String username) {
        return (List<Bookmark>) bookmarkRepository.findBookmarksByUsername(username);
    }

    @PostMapping("/bookmark")
    public ResponseEntity<Bookmark> createBookmark(@RequestBody Bookmark bookmark) {
        try {
            System.out.println(bookmark.toString());
            Bookmark _bookmark = bookmarkRepository
                    .save(new Bookmark(bookmark.getUsername(), bookmark.getRepo_name(), bookmark.getRepo_url(),
                            bookmark.getOwner_name(), bookmark.getOwner_url(),
                            bookmark.getAvatar_url()));
            return new ResponseEntity<>(_bookmark, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/unBookmark")
    public ResponseEntity<Bookmark> updateBookmark(@RequestBody Bookmark bookmark) {
        try {
            System.out.println(bookmark.toString());
            bookmarkRepository.findByUsernameAndRepoUrl(bookmark.getUsername(), bookmark.getRepo_url());
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
