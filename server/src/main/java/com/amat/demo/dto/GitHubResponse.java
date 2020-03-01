package com.amat.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class GitHubResponse<T> {
    private List<T> items;

    public List<T> getItems() {
        return items;
    }
}
