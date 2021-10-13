package com.fahminajjar.todoservice.dto;

import com.fahminajjar.todoservice.model.Todo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo todoDtoToTodo(TodoDto todoDto);
    TodoDto todoToTodoDto(Todo todo);
}
