package com.example.layered.dto;

import com.example.layered.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private Long scheduleId;
    private String writer;
    private String toDo;
    private String password;
    private java.sql.Timestamp createdDate;
    private java.sql.Timestamp updatedDate;

    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.writer = schedule.getWriter();
        this.password = schedule.getPassword();
        this.toDo = schedule.getToDo();
        this.createdDate = schedule.getCreatedDate();
        this.updatedDate = schedule.getUpdatedDate();
    }
}
