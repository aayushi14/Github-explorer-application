package com.amat.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    private int id;
    private String login;
    private String avatar_url;
    private String html_url;

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }
}
