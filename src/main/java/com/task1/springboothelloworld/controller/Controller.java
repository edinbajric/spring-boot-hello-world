package com.task1.springboothelloworld.controller;

import com.task1.springboothelloworld.ReturnMessage;
import com.task1.springboothelloworld.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/secure")

public class Controller {
    @GetMapping("/hello-rest")
    public String PrintHelloWorld(){

        return "Hello World";
    }

    @GetMapping(path="/hello/{language}")

    public String HelloWorld(@PathVariable String language) throws Exception {
            ReturnMessage result = new ReturnMessage();
            return result.returnTranslation(language);
    }

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/admin")
    public ModelAndView AdminPage() {

        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("messages", messageRepository.findAll());
        return modelAndView;
    }
}



