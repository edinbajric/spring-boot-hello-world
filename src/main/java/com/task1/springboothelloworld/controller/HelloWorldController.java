package com.task1.springboothelloworld.controller;

import com.task1.springboothelloworld.entity.Message;
import com.task1.springboothelloworld.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Profile("database")
@Controller
@RequestMapping("/api/db")

public class HelloWorldController {

    @Autowired
    private final MessageService messageService;

    public HelloWorldController(MessageService messageService) {
        this.messageService = messageService;
    }

    @ResponseBody
    @GetMapping("/hello-rest")
    public String printHelloWorld() {

        return "Hello World";
    }

    @ResponseBody
    @GetMapping(path = "/secure/hello/{language}")

    public String helloWorld(@PathVariable String language) {
        Message rawResult = messageService.getMessages(language);

        return rawResult.getMessage();
    }

    @GetMapping("/admin")
    public ModelAndView adminPage() {
        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("messages", messageService.getAll());

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
        messageService.save(message);

        return "redirect:/api/db/admin";
    }

    @ResponseBody
    @GetMapping("/hello")
    public String returnHello() {

        return "Hello from db!";
    }
}



