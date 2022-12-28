package com.task1.springboothelloworld.service;

import com.task1.springboothelloworld.entity.Message;
import com.task1.springboothelloworld.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Object> getMessages(String language){
        return messageRepository.findByLanguage(language);
    }

    public List<Message> getAll(){
        return messageRepository.findAll();
    }

    public <S extends Message> S save(S entity) {
        return messageRepository.save(entity);
    }

}
