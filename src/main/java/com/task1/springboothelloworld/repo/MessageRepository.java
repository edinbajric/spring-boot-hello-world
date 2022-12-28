package com.task1.springboothelloworld.repo;

import com.task1.springboothelloworld.entity.Message;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Profile("database")
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Message findByLanguage(String language);
}
