package com.example.layered.service;

import com.example.layered.dto.ScheduleRequestDto;
import com.example.layered.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);

    List<ScheduleResponseDto> findAllSchedules();

    ScheduleResponseDto findScheduleById(Long id);

    ScheduleResponseDto updateSchedule(Long id, String writer, String toDo, String password);

    ScheduleResponseDto updateToDo(Long id, String writer, String toDo, String password);

    void deleteSchedule(Long id);

}
