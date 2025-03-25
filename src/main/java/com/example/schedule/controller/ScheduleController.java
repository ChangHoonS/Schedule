package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto dto) {

        // 식별자가 1씩 증가하도록 만듬
        Long scheduleIds = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;

        // 요청받은 데이터로 Schedule 객체 생성
        Schedule schedule = new Schedule(scheduleIds, dto.getToDo(), dto.getPassword(), dto.getWriter());

        scheduleList.put(scheduleIds, schedule);

        return new ScheduleResponseDto(schedule);
    }



    @GetMapping("/{id}")
    public ScheduleResponseDto findScheduleById(@PathVariable Long id) {
        Schedule schedule = scheduleList.get(id);

        return new ScheduleResponseDto(schedule);

    }

    @PutMapping("/{id}")
    public ScheduleResponseDto updateScheduleById(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto dto
    ) {
        Schedule schedule = scheduleList.get(id);

        schedule.update(dto);

        return new ScheduleResponseDto(schedule);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {

        scheduleList.remove(id);

    }
}

