package com.group.libraryapp.dto.calculator.request;

public class FruitUpdateRequest {
    private long id;

    public FruitUpdateRequest(long id) {
        this.id = id;
    }

    public FruitUpdateRequest() {
    }

    public long getId() {
        return id;
    }
}
