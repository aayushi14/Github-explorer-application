package com.amat.demo.entity;

import com.amat.demo.dto.Bookmark;
import com.amat.demo.rest.BookmarkController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class BookmarkEntity extends RepresentationModel {
    /*
    private final Bookmark bookmark;

    public BookmarkEntity(Bookmark bookmark) {
        this.bookmark = bookmark;
        add(new Link(bookmark.getRepo_url(), "bookmark-uri"));
        add(linkTo(methodOn(BookmarkController.class).readBookmarks(null)).withRel("bookmarks"));
        add(linkTo(methodOn(BookmarkController.class).readBookmark(null, bookmark.getId())).withSelfRel());
    }

    public Bookmark getBookmark() {
        return bookmark;
    }
    */
}
