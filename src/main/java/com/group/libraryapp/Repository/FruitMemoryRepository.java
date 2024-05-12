package com.group.libraryapp.Repository;

import com.group.libraryapp.domain.Fruit;
import com.group.libraryapp.dto.calculator.request.FruitRequest;
import com.group.libraryapp.dto.calculator.request.FruitUpdateRequest;
import com.group.libraryapp.dto.response.FruitStatResponse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FruitMemoryRepository implements FruitRepository {
    private List<Fruit> fruits = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    @Override
    public void saveFruit(FruitRequest request) {
        long id = counter.incrementAndGet();
        Fruit fruit = new Fruit(id, request.getName(), request.getDate(), request.getPrice(), false);
        fruits.add(fruit);
    }



    @Override
    public void updateFruit(FruitUpdateRequest request) {
        for (Fruit fruit : fruits) {
            if (fruit.getId().equals(request.getId())) {
                fruit.setSold(true);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public FruitStatResponse getFruitStatResponse(String name) {
        long soldSum = fruits.stream()
                .filter(fruit -> fruit.getName().equals(name) && fruit.isSold())
                .mapToLong(Fruit::getPrice)
                .sum();
        long notSoldSum = fruits.stream()
                .filter(fruit -> fruit.getName().equals(name) && !fruit.isSold())
                .mapToLong(Fruit::getPrice)
                .sum();

        return new FruitStatResponse(soldSum, notSoldSum);
    }
}
