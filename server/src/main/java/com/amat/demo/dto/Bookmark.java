package com.amat.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bookmarks")
public class Bookmark {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String repo_name;
    private String repo_url;
    private String owner_name;
    private String owner_url;
    private String avatar_url;

//    @JsonIgnore
//    @ManyToOne
//    private Account account;

    public Bookmark() {
    }

    public Bookmark(String username, String repo_name, String repo_url, String owner_name, String owner_url, String avatar_url) {
        this.username = username;
        this.repo_name = repo_name;
        this.repo_url = repo_url;
        this.owner_name = owner_name;
        this.owner_url = owner_url;
        this.avatar_url = avatar_url;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getRepo_name() {
        return repo_name;
    }

    public String getRepo_url() {
        return repo_url;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public String getOwner_url() {
        return owner_url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", repo_name='" + repo_name + '\'' +
                ", repo_url='" + repo_url + '\'' +
                ", owner_name='" + owner_name + '\'' +
                ", owner_url='" + owner_url + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                '}';
    }
}
