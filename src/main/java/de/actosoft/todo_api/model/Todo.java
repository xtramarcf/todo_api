package de.actosoft.todo_api.model;


import de.actosoft.todo_api.controller.Dto.TodoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String content;
    private String createdAt;
    private boolean important = false;
    private boolean done = false;


    public Todo(TodoDto todoDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        this.title = todoDto.title();
        this.content = todoDto.content();
        this.important = todoDto.important();
        this.done = todoDto.done();
        this.createdAt = LocalDateTime.now().format(formatter);
    }

}
