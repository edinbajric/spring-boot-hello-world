package com.task1.springboothelloworld.service;

import com.task1.springboothelloworld.entity.Message;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("database")

public interface MessageService {

    Message getMessages(String language);

    List<Message> getAll();

    <S extends Message> void save(S entity);

    void saveAll(List<Message> data);
}
