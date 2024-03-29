package de.actosoft.todo_api.service;


import de.actosoft.todo_api.controller.Dto.TodoDto;
import de.actosoft.todo_api.model.Todo;
import de.actosoft.todo_api.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    public final TodoRepository todoRepository;


    @Transactional
    public void createTodo(TodoDto todoDto) {
        todoRepository.save(new Todo(todoDto));
    }

    public List<Todo> readAllTodos() {
        return todoRepository.findAll();
    }


    @Transactional
    public void updateTodo(TodoDto todoDto) {

        Todo todo = todoRepository.findById(todoDto.id()).orElseThrow(IllegalStateException::new);

        todo.setContent(todoDto.content());
        todo.setTitle(todoDto.title());
        todo.setImportant(todoDto.important());
        todo.setDone(todoDto.done());

        todoRepository.save(todo);
    }

    @Transactional
    public void deleteTodo(int id) {

        Todo todo = todoRepository.findById(id).orElseThrow(IllegalStateException::new);

        todoRepository.delete(todo);
    }

    public TodoDto escapeTodoDto(TodoDto todoDto) {

        return new TodoDto(
                todoDto.id(),
                StringEscapeUtils.escapeJava(todoDto.title()),
                StringEscapeUtils.escapeJava(todoDto.content()),
                todoDto.important(),
                todoDto.done()
        );
    }

    public void initializeExamples() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        List<Todo> todoList = List.of(
                Todo.builder()
                        .createdAt(LocalDateTime.now().format(formatter))
                        .title("Actosoft")
                        .content("Implementing Todo-Project.")
                        .important(true)
                        .done(false)
                        .build(),
                Todo.builder()
                        .createdAt(LocalDateTime.now().format(formatter))
                        .title("Sport")
                        .content("Swimming with Max.")
                        .important(true)
                        .done(false)
                        .build(),
                Todo.builder()
                        .createdAt(LocalDateTime.now().format(formatter))
                        .title("Home")
                        .content("Clean up the living room and the kitchen. ")
                        .important(false)
                        .done(false)
                        .build()
        );

        todoRepository.saveAll(todoList);
    }
}
