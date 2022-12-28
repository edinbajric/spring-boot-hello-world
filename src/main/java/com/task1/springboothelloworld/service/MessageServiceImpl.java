package com.task1.springboothelloworld.service;

import com.task1.springboothelloworld.entity.Message;
import com.task1.springboothelloworld.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("database")
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
    public <S extends Message> void save(S entity) {
        messageRepository.save(entity);
    }

    @Override
    public void saveAll(List<Message> data) {
        messageRepository.saveAll(data);
    }
}
