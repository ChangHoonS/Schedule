package com.example.layered.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Schedule {

    @Setter
    private Long scheduleId;
    private String writer;
    private String toDo;
    private String password;
    private java.sql.Timestamp createdDate;
    private java.sql.Timestamp updatedDate;

    public Schedule(String writer, String toDo, String password) {
        this.writer = writer;
        this.toDo = toDo;
        this.password = password;
    }

    public Schedule(Long scheduleId, String writer, String toDo, String password) {
        this.scheduleId = scheduleId;
        this.writer = writer;
        this.toDo = toDo;
        this.password = password;
    }

    public void update(String writer, String toDo, String password) {
        this.writer = writer;
        this.toDo = toDo;
        this.password = password;
        this.updatedDate = updatedDate;
    }

    public void updateToDo(String toDo) {
        this.toDo = toDo;
    }
}
