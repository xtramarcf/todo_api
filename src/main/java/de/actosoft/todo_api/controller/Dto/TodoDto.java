package de.actosoft.todo_api.controller.Dto;


import jakarta.validation.constraints.NotNull;

public record TodoDto(

        int id,
        @NotNull
        String title,
        @NotNull
        String content,
        boolean important,
        boolean done
) {
}
