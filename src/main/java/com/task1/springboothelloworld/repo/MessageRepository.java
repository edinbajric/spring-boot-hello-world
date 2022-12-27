package com.task1.springboothelloworld.repo;

import com.task1.springboothelloworld.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("select m.message from Message m where m.language=:language")
    List<Object> findByLanguage(@Param("language") String language);
}
