package com.fahminajjar.todoservice.config;

import com.fahminajjar.todoservice.model.Todo;
import com.fahminajjar.todoservice.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TodoConfig {

    @Bean
    CommandLineRunner commandLineRunner(TodoRepository repository) {
        return args -> {
            Todo todo1 = new Todo("Test Todo!");
            Todo todo2 = new Todo("Second Todo!");
            repository.saveAll(List.of(todo1, todo2));
        };
    }
}
