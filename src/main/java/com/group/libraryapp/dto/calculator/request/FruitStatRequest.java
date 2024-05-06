package com.group.libraryapp.dto.calculator.request;

public class FruitStatRequest {
    private String name;
    private long price;
    private long status;

    public FruitStatRequest(String name, long price, long status) {
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public long getStatus() {
        return status;
    }
}
