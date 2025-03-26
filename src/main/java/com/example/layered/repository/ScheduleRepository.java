package com.example.layered.repository;

import com.example.layered.dto.ScheduleResponseDto;
import com.example.layered.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {

    Schedule saveSchedule(Schedule schedule);

    List<ScheduleResponseDto> findAllSchedules();

    Schedule findScheduleById(Long id);

    void deleteSchedule(Long id);
}
