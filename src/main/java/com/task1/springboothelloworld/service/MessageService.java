package com.task1.springboothelloworld.service;

import com.task1.springboothelloworld.entity.Message;

import java.util.List;

public interface MessageService {

    Message getMessages(String language);

    List<Message> getAll();

    <S extends Message> S save(S entity);
}
