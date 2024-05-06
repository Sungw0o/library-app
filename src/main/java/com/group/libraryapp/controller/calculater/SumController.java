package com.group.libraryapp.controller.calculater;

import com.group.libraryapp.dto.calculator.request.CalSumRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {

    @PostMapping("/api/v1/sums")
    public int CalSum(@RequestBody CalSumRequest request){
        return request.getSum();
    }

}
