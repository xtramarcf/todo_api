package de.actosoft.todo_api.controller;


import de.actosoft.todo_api.controller.Dto.TodoDto;
import de.actosoft.todo_api.model.Todo;
import de.actosoft.todo_api.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RestController {

    public final TodoService todoService;


    @PostMapping("/create-todo")
    public ResponseEntity<String> createTodo(@RequestBody @Valid TodoDto todoDto, BindingResult result) {

        if (result.hasErrors())
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .build();

        TodoDto escapedTodoDto = todoService.escapeTodoDto(todoDto);

        todoService.createTodo(escapedTodoDto);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/get-all-todos")
    public ResponseEntity<List<Todo>> getAllTodos() {

        List<Todo> allTodos = todoService.readAllTodos();

        return ResponseEntity.ok().body(allTodos);
    }


    @PatchMapping("/update-todo")
    public ResponseEntity<String> updateTodo(@RequestBody @Valid TodoDto todoDto, BindingResult result) {

        if (result.hasErrors())
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .build();

        TodoDto escapedTodoDto = todoService.escapeTodoDto(todoDto);

        todoService.updateTodo(escapedTodoDto);

        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/delete-todo")
    public ResponseEntity<String> deleteTodo(@RequestParam("id") int id) {

        todoService.deleteTodo(id);

        return ResponseEntity.ok().build();
    }


}
