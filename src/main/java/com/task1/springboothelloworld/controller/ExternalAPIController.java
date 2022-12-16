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
public class ExternalAPIController {
    @GetMapping(path="/{name}")
    public Object displayCountry(@PathVariable String name) {
        String url = "https://api.genderize.io?name={name}";
        RestTemplate restTemplate = new RestTemplate();

        Object result = restTemplate.getForObject(url, Object.class, name);

        return result;
    }
}
