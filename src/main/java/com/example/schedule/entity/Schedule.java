package com.example.schedule.entity;

import com.example.schedule.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long scheduleId;
    private String writer;
    private String toDo;
    private String password;
    private java.sql.Timestamp createdDate;
    private java.sql.Timestamp updatedDate;

    public Schedule(Long scheduleId, String writer, String toDo, String password) {
        this.scheduleId = scheduleId;
        this.writer = writer;
        this.toDo = toDo;
        this.password = password;
    }

    public void update(ScheduleRequestDto dto) {
        this.writer = dto.getWriter();
        this.toDo = dto.getToDo();
        this.password = dto.getPassword();
        this.updatedDate = dto.getUpdatedDate();
    }

    public void updateToDo(ScheduleRequestDto dto) {
        this.toDo = dto.getToDo();
    }
}
