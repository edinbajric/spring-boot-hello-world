package com.task1.springboothelloworld.controller;

import com.task1.springboothelloworld.entity.Message;
import com.task1.springboothelloworld.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Profile("database")
@Controller
@RequestMapping("/api/db")

public class DatabaseController {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseController.class);
    private final String errorMessage = "The length of the message must be at least 5 characters long and/or your message contains invalid characters";

    @Autowired
    private final MessageService messageService;

    public DatabaseController(MessageService messageService) {
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
    public String savePage(@Valid @ModelAttribute("messages") Message message) {
        messageService.save(message);

        return "redirect:/api/db/admin";
    }

    @ResponseBody
    @GetMapping("/hello")
    public String returnHello() {

        return "Hello from db!";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleValidationException(Exception ex) {
        logger.error(ex.getMessage());
        ModelAndView modelAndView = new ModelAndView("error");

        modelAndView.addObject("message", errorMessage);

        return modelAndView;
    }
}



