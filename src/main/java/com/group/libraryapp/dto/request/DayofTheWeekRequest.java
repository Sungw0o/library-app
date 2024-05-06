package com.group.libraryapp.dto.request;

import java.time.*;
public class DayofTheWeekRequest {
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
