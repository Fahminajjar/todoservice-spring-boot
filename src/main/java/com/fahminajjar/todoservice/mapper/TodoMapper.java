package com.fahminajjar.todoservice.mapper;

import com.fahminajjar.todoservice.model.Todo;
import com.fahminajjar.todoservice.dto.TodoDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo todoDtoToTodo(TodoDto todoDto);
    TodoDto todoToTodoDto(Todo todo);
}
