package com.task1.springboothelloworld.data;

import com.task1.springboothelloworld.entity.Message;
import com.task1.springboothelloworld.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Profile("database")
@Component
public class InitialData {
    @Autowired
    private final MessageService messageService;

    public InitialData(MessageService messageService) {
        this.messageService = messageService;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        List<Message> data = new ArrayList<>();

        data.add(0, new Message(null, "Bosnian", "Zdravo svijete"));
        data.add(1, new Message(null, "Dutch", "Hallo Wereld"));
        data.add(2, new Message(null, "Finnish", "Hei maailma"));
        data.add(3, new Message(null, "French", "Bonjour le monde"));
        data.add(4, new Message(null, "German", "Hallo Welt"));
        data.add(5, new Message(null, "Norwegian", "Hei Verden"));
        data.add(6, new Message(null, "Romanian", "Salut Lume"));
        data.add(7, new Message(null, "Spanish", "Hola Mundo"));
        data.add(8, new Message(null, "Danish", "Hej Verden"));
        data.add(9, new Message(null, "Latvian", "Sveika pasaule"));

        messageService.saveAll(data);
    }
}
