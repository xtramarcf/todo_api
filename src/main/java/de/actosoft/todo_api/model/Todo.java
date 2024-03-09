package de.actosoft.todo_api.model;


import de.actosoft.todo_api.controller.Dto.TodoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String content;
    private LocalDateTime createdAt;
    private boolean important = false;
    private boolean done = false;


    public Todo(TodoDto todoDto) {
        this.content = todoDto.content();
        this.important = todoDto.important();
        this.done = todoDto.done();
    }

}
