package com.group.libraryapp.Repository;

import com.group.libraryapp.dto.calculator.request.FruitRequest;
import com.group.libraryapp.dto.calculator.request.FruitUpdateRequest;
import com.group.libraryapp.dto.response.FruitStatResponse;

public interface FruitRepository {
    void saveFruit(FruitRequest request);
    void updateFruit(FruitUpdateRequest request);
    FruitStatResponse getFruitStatResponse(String name);
}
