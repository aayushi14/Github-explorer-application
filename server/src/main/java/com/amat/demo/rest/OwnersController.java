package com.amat.demo.rest;

import com.amat.demo.dto.GitHubOwnersResponse;
import com.amat.demo.dto.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OwnersController {
    @Autowired
    private RestTemplate restTemplate;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/api/users")
    public List<Owner> search(@RequestParam(name = "q") String query) {
        ResponseEntity<GitHubOwnersResponse> forEntity =
                restTemplate.getForEntity(String.format("https://api.github.com/search/users?q=%s", query), GitHubOwnersResponse.class);
        return forEntity.getBody().getItems();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/api/users/{login}")
    public Owner get(@PathVariable("login") String login){
        ResponseEntity<Owner> forEntity = restTemplate.getForEntity(String.format("https://api.github.com/users/%s", login), Owner.class);
        return forEntity.getBody();
    }
}
