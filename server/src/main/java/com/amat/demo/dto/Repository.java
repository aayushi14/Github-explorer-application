package com.amat.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repository {
    private int id;
    private String name;
    private Owner owner;
    private String html_url;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getHtml_url() {
        return html_url;
    }
}
