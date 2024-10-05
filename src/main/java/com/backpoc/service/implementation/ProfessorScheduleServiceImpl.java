package com.backpoc.service.implementation;

import java.util.*;

import org.springframework.stereotype.Service;

import com.backpoc.persistence.entity.Professor;
import com.backpoc.persistence.entity.Schedule;
import com.backpoc.persistence.repository.ProfessorRepository;
import com.backpoc.presentation.dto.CourseScheduleDTO;
import com.backpoc.presentation.dto.ProfessorScheduleDTO;
import com.backpoc.service.interfaces.IProfessorScheduleService;
import com.backpoc.util.mapper.ProfessorScheduleMapper;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProfessorScheduleServiceImpl implements IProfessorScheduleService {

    private final ProfessorRepository professorRepository;
    private final ProfessorScheduleMapper professorScheduleMapper;

    public ProfessorScheduleServiceImpl(ProfessorRepository professorRepository, ProfessorScheduleMapper professorScheduleMapper) {
        this.professorRepository = professorRepository;
        this.professorScheduleMapper = professorScheduleMapper;
    }

    @Override
    public ProfessorScheduleDTO getProfessorSchedule(Long professorId) {

        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new EntityNotFoundException("Professor not found with id: " + professorId));

        Map<String, List<CourseScheduleDTO>> dailyCourses = new HashMap<>();

        for (Schedule schedule : professor.getSchedules()) {
            String dayOfWeek = schedule.getWeekday();
            CourseScheduleDTO courseScheduleDTO = professorScheduleMapper.toCourseScheduleDTO(schedule);

            dailyCourses.putIfAbsent(dayOfWeek, new ArrayList<>());
            dailyCourses.get(dayOfWeek).add(courseScheduleDTO);
        }

        return professorScheduleMapper.toProfessorScheduleDTO(professor,
                dailyCourses);
    }
}
