package com.example.layered.repository;

import com.example.layered.dto.ScheduleResponseDto;
import com.example.layered.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository

public class ScheduleRepositoryImpl implements ScheduleRepository {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();


    @Override
    public Schedule saveSchedule(Schedule schedule) {

        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
        schedule.setScheduleId(scheduleId);

        scheduleList.put(scheduleId, schedule);

        return schedule;
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {

        // init List
        List<ScheduleResponseDto> allSchedules = new ArrayList<>();

        // HashMap<Memo> -> List<MemoResponseDto>
        for (Schedule schedule : scheduleList.values()) {
            ScheduleResponseDto dto = new ScheduleResponseDto(schedule);
            allSchedules.add(dto);

        }

        return allSchedules;
    }

    @Override
    public Schedule findScheduleById(Long id) {
        return scheduleList.get(id);
    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleList.remove(id);
    }

}
