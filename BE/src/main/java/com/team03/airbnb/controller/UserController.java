package com.team03.airbnb.controller;

import com.team03.airbnb.entity.User;
import com.team03.airbnb.oauth.github.Github;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class UserController {

    @GetMapping("/callback")
    public ResponseEntity<User> login(@RequestParam String code) {
        RestTemplate restTemplate = new RestTemplate();
        Github github = new Github();

        String url = github.getUrlForAccesToken(code);
        github = restTemplate.getForObject(url, Github.class);

        System.out.println(github.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(github.getAccess_token());

        User user = new User();
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        String url2 = "https://api.github.com/user";
        ResponseEntity<User> userResponseEntity = restTemplate.exchange(url2, HttpMethod.GET, entity, User.class);

        return userResponseEntity;

    }

}
