package com.fahminajjar.todoservice.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TodoDto {

    private Long id;

    @NotNull
    @Min(3)
    private String text;

    private Boolean isCompleted;

    public TodoDto(Long id, String text, Boolean isCompleted) {
        this.id = id;
        this.text = text;
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
