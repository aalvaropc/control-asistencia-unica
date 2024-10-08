package com.backpoc.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.backpoc.persistence.entity.Attendancy;
import com.backpoc.presentation.dto.AttendancyDTO;

@Mapper(componentModel = "spring")
@Component
public interface AttendancyMapper {

    AttendancyMapper INSTANCE = Mappers.getMapper(AttendancyMapper.class);


    Attendancy  toEntity(AttendancyDTO attendancyDTO);


    @Mapping(source = "schedule.course.name", target = "courseName")
    @Mapping(source = "schedule.id", target = "scheduleId")
    AttendancyDTO toDTO(Attendancy attendancy);

}
