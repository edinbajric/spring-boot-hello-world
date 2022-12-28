package com.task1.springboothelloworld.service;

import com.task1.springboothelloworld.entity.Message;
import com.task1.springboothelloworld.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message getMessages(String language){
        return messageRepository.findByLanguage(language);
    }

    @Override
    public List<Message> getAll(){
        return messageRepository.findAll();
    }

    @Override
    public <S extends Message> S save(S entity) {
        return messageRepository.save(entity);
    }

    @Override
    public List<Message> saveAll(List<Message> data) {
        return messageRepository.saveAll(data);
    }
}
