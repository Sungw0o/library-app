package com.group.libraryapp.dto.response;
import com.group.libraryapp.dto.request.DayofTheWeekRequest;
import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class DayOfTheWeekResponse {
    private String dayOfTheWeek;

    public DayOfTheWeekResponse(DayOfWeek dayOfWeek){
        this.dayOfTheWeek = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREA).toUpperCase();
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}
