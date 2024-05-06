package com.group.libraryapp.controller.dayoftheweek;

import com.group.libraryapp.dto.request.DayofTheWeekRequest;
import com.group.libraryapp.dto.response.DayOfTheWeekResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.time.format.DateTimeFormatter;

@RestController
public class DayController {

    @GetMapping("api/v1/day-of-the-week")
    public DayOfTheWeekResponse getDayOfTheWeek(@RequestParam("date") String dateString){
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        DayOfTheWeekResponse response = new DayOfTheWeekResponse(date.getDayOfWeek());
        return response;
    }

}
