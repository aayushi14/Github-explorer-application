package com.amat.demo.rest;

import com.amat.demo.dto.GitHubRepositoriesResponse;
import com.amat.demo.dto.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
public class RepositoriesController {
    @Autowired
    private RestTemplate restTemplate;

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/api/repositories")
    public List<Repository> repositories(@RequestParam(name = "q") String query) {
        ResponseEntity<GitHubRepositoriesResponse> forEntity =
                restTemplate.getForEntity(
                        String.format("https://api.github.com/search/repositories?q=language:Javascript+and+PHP+%s", query),
                        GitHubRepositoriesResponse.class);
        List<Repository> repoList = forEntity.getBody().getItems();
        Set<Repository> reposWithQueryString = new HashSet<>();
        for (Repository repo: repoList) {
            if (repo.getName().toLowerCase().contains(query.toLowerCase())) {
                reposWithQueryString.add(repo);
            }
            System.out.println(repo.toString());
        }
        List<Repository> repoListWithQueryString = reposWithQueryString.stream().collect(Collectors.toList());
        return repoListWithQueryString;
    }
}
