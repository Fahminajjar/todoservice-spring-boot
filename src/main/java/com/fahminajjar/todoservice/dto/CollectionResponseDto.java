package com.fahminajjar.todoservice.dto;

import java.util.Collection;

public class CollectionResponseDto<T> {
    private Collection<T> data;

    public CollectionResponseDto(Collection<T> data) {
        this.data = data;
    }

    public CollectionResponseDto() {
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CollectionResponseDto{" +
                "data=" + data +
                '}';
    }
}
