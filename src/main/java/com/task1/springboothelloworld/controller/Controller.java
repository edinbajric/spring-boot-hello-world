package com.task1.springboothelloworld.controller;

import com.task1.springboothelloworld.query.ReturnMessage;
import com.task1.springboothelloworld.entity.Message;
import com.task1.springboothelloworld.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Profile("database")
@RestController
@RequestMapping("/secure")

public class Controller {
    public Controller() {
    }

    @GetMapping("/hello-rest")
    public String printHelloWorld(){

        return "Hello World";
    }

    @GetMapping(path="/hello/{language}")

    public String helloWorld(@PathVariable String language) throws Exception {
            ReturnMessage result = new ReturnMessage();
            return result.returnTranslation(language);
    }

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/admin")
    public ModelAndView adminPage() {

        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("messages", messageRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/admin/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView("add");
        Message message = new Message();
        modelAndView.addObject("messages", message);

        return modelAndView;
    }

    @PostMapping("/admin/save")
    public String savePage(@ModelAttribute("messages") Message message) {
        messageRepository.save(message);
        return "Pair added successfully, go back to Admin Page to see changes";
    }
}



