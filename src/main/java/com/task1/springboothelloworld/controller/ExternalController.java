package com.task1.springboothelloworld.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Profile("external")
@RestController
@RequestMapping("/api/external")
public class ExternalController {
    @GetMapping(path="/{name}")
    public Object displayGender(@PathVariable String name) {
        String url = "https://api.genderize.io?name={name}";
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, Object.class, name);
    }

    @GetMapping("/hello")
    public String returnHello() {

        return "Hello from external!";
    }
}
