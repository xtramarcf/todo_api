package de.actosoft.todo_api;

import de.actosoft.todo_api.service.TodoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TodoService todoService) {
        return args -> {
            todoService.initializeExamples();
        };
    }

}
