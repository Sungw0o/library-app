package com.group.libraryapp.dto.calculator.request;

import java.util.*;
public class CalSumRequest {
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getSum(){
        return  numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
