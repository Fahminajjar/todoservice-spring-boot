package com.fahminajjar.todoservice.service;

import com.fahminajjar.todoservice.model.Todo;
import com.fahminajjar.todoservice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodo(Long id) {
        return todoRepository.findById(id);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        boolean exists = todoRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("todo with id " + id + " doesn't exist");
        }
        todoRepository.deleteById(id);
    }

    @Transactional
    public Todo updateTodoPartially(Long id, Todo updatedTodo) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "todo with id " + id + " does not exist"
                ));

        var newText = updatedTodo.getText();
        if (newText != null && newText.length() > 1 && !Objects.equals(newText, todo.getText())) {
            todo.setText(newText);
        }

        var isCompleted = updatedTodo.getIsCompleted();
        if (!Objects.equals(isCompleted, todo.getIsCompleted())) {
            todo.setIsCompleted(isCompleted);
        }

        return todoRepository.save(todo);
    }

    @Transactional
    public Todo updateTodo(Long id, Todo newTodo) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "todo with id " + id + " does not exist"
                ));
        todo.setText(newTodo.getText());
        todo.setIsCompleted(newTodo.getIsCompleted());
        return todoRepository.save(todo);
    }

}
