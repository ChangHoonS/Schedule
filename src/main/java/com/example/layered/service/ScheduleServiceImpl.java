package com.example.layered.service;

import com.example.layered.dto.ScheduleRequestDto;
import com.example.layered.dto.ScheduleResponseDto;
import com.example.layered.entity.Schedule;
import com.example.layered.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service

public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {
        // 요청받은 데이터로  Schedule 객체 생성, ID 없음
        Schedule schedule = new Schedule(dto.getWriter(), dto.getToDo(), dto.getPassword());

        // DB에 저장
        Schedule savedSchedule = scheduleRepository.saveSchedule(schedule);

        return new ScheduleResponseDto(savedSchedule);
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {

        return scheduleRepository.findAllSchedules();
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long id) {

        Schedule schedule = scheduleRepository.findScheduleById(id);

        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        return new ScheduleResponseDto(schedule);
    }

    @Override
    public ScheduleResponseDto updateSchedule(Long id, String writer, String toDo, String password) {

        Schedule schedule = scheduleRepository.findScheduleById(id);

        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        if (writer == null || toDo == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The writer and toDo are required values.");
        }

        schedule.update(writer, toDo, password);

        return new ScheduleResponseDto(schedule);
    }

    @Override
    public ScheduleResponseDto updateToDo(Long id, String writer, String toDo, String password) {

        Schedule schedule = scheduleRepository.findScheduleById(id);

        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        if (writer != null || toDo == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The writer and toDo are required values.");
        }

        schedule.updateToDo(toDo);

        return new ScheduleResponseDto(schedule);
    }

    @Override
    public void deleteSchedule(Long id) {

        Schedule schedule = scheduleRepository.findScheduleById(id);

        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        scheduleRepository.deleteSchedule(id);
    }

}
