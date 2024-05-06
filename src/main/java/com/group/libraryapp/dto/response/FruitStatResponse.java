package com.group.libraryapp.dto.response;

public class FruitStatResponse {

    private long salesAmount;
    private long notsalesAmount;

    public FruitStatResponse(long salesAmount, long notsalesAmount) {
        this.salesAmount = salesAmount;
        this.notsalesAmount = notsalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotsalesAmount() {
        return notsalesAmount;
    }
}
