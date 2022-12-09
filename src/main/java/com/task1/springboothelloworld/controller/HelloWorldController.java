package com.task1.springboothelloworld.controller;

import com.task1.springboothelloworld.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {
    @GetMapping("/hello-rest")
    public String PrintHelloWorld(){

        return "Hello World";
    }

    @GetMapping(path="/hello/{language}")
    public String HelloWorld(@PathVariable String language) throws Exception {
            Message result = new Message();
            return result.returnTranslation(language);
    }

    @GetMapping("/secure/hello")
    public String SecureHelloWorld() {

        return "Hello World";
    }
}



