package com.example.schedule.dto;

import lombok.Getter;

@Getter

public class ScheduleRequestDto {

    private String writer;
    private String toDo;
    private String password;
    private java.sql.Timestamp updatedDate;
}
