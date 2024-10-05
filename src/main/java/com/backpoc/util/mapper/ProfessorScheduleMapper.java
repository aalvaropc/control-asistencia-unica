package com.backpoc.util.mapper;

import java.util.List;
import java.util.Map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.backpoc.persistence.entity.Professor;
import com.backpoc.persistence.entity.Schedule;
import com.backpoc.presentation.dto.CourseScheduleDTO;
import com.backpoc.presentation.dto.ProfessorScheduleDTO;

@Mapper(componentModel = "spring")
@Component
public interface ProfessorScheduleMapper {

    @Mapping(source = "professor.user.firstName", target = "professorFirstName")
    @Mapping(source = "professor.user.lastName", target = "professorLastName")
    @Mapping(source = "professor.department.faculty.name", target = "facultyName")
    @Mapping(target = "dailyCourses", expression = "java(mapDailyCourses(dailyCourses))")
    ProfessorScheduleDTO toProfessorScheduleDTO(Professor professor, Map<String, List<CourseScheduleDTO>> dailyCourses);

    @Mapping(source = "course.name", target = "courseName")
    @Mapping(source = "startTime", target = "startDateTime")
    @Mapping(source = "endTime", target = "endDateTime")
    CourseScheduleDTO toCourseScheduleDTO(Schedule schedule);

    default Map<String, List<CourseScheduleDTO>> mapDailyCourses(Map<String, List<CourseScheduleDTO>> dailyCourses) {
        return dailyCourses;
    }

}
