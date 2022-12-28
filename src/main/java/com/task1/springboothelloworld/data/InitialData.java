package com.task1.springboothelloworld.data;

import com.task1.springboothelloworld.entity.Message;
import com.task1.springboothelloworld.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InitialData {
    @Autowired
    private final MessageService messageService;

    public InitialData(MessageService messageService) {
        this.messageService = messageService;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        messageService.save(new Message(1L, "Bosnian", "Zdravo svijete"));
        messageService.save(new Message(2L, "Dutch", "Hallo Wereld"));
        messageService.save(new Message(3L, "Finnish", "Hei maailma"));
        messageService.save(new Message(4L, "French", "Bonjour le monde"));
        messageService.save(new Message(5L, "German", "Hallo Welt"));
        messageService.save(new Message(6L, "Norwegian", "Hei Verden"));
        messageService.save(new Message(7L, "Romanian", "Salut Lume"));
        messageService.save(new Message(8L, "Spanish", "Hola Mundo"));
        messageService.save(new Message(9L, "Danish", "Hej Verden"));
        messageService.save(new Message(10L, "Latvian", "Sveika pasaule"));
    }
}
