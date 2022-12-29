package com.task1.springboothelloworld.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Profile("database")
@Entity
@Table(name="messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language;

    @Pattern(regexp = "^[a-zA-Z ]+!?$", message = "Message can contain characters and one exclamation point only")
    @Size(min = 5, message = "Message length must be bigger than 5")
    @Valid
    private String message;
}
