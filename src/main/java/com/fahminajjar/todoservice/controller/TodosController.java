package com.fahminajjar.todoservice.controller;

import com.fahminajjar.todoservice.dto.CollectionResponseDto;
import com.fahminajjar.todoservice.dto.TodoDto;
import com.fahminajjar.todoservice.dto.TodoMapper;
import com.fahminajjar.todoservice.exception.TodoNotFoundException;
import com.fahminajjar.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/todos")
public class TodosController {

    private final TodoService todoService;
    private final TodoMapper todoMapper;

    @Autowired
    public TodosController(TodoService todoService, TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @GetMapping
    public CollectionResponseDto<TodoDto> getTodos() {
        var todos = todoService.getTodos();
        return new CollectionResponseDto<>(todos
                .stream()
                .map(todoMapper::todoToTodoDto)
                .toList()
        );
    }

    @GetMapping("{id}")
    public TodoDto getTodo(@PathVariable Long id) {
        var todo = todoService.getTodo(id).orElse(null);
        if (todo == null) {
            throw new TodoNotFoundException("Todo not found");
        }
        return todoMapper.todoToTodoDto(todo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoDto createTodo(@Valid @RequestBody TodoDto todoDto) {
        var todo = todoMapper.todoDtoToTodo(todoDto);
        var savedTodo = todoService.createTodo(todo);
        return todoMapper.todoToTodoDto(savedTodo);
    }

    @PutMapping("/{id}")
    public TodoDto updateTodo(
            @PathVariable Long id,
            @Valid @RequestBody TodoDto todoDto) {
        var todo = todoService.updateTodo(id, todoMapper.todoDtoToTodo(todoDto));
        return todoMapper.todoToTodoDto(todo);
    }

    @PatchMapping("/{id}")
    public TodoDto updateTodoPartially(
            @PathVariable Long id,
            @RequestBody TodoDto todoDto) {
        var todo = todoService.updateTodoPartially(id, todoMapper.todoDtoToTodo(todoDto));
        return todoMapper.todoToTodoDto(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

}
