package com.example.layered.dto;

import lombok.Getter;

@Getter

public class ScheduleRequestDto {

    private String writer;
    private String toDo;
    private String password;
    private java.sql.Timestamp updatedDate;
}
