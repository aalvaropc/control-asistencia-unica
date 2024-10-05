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

    AttendancyDTO toDTO(Attendancy attendancy);

    Attendancy toEntity(AttendancyDTO attendancyDTO);


    @Mapping(source = "course.name", target = "courseName") // Asumiendo que la entidad Attendancy tiene un objeto Course con un atributo name
    AttendancyDTO attendancyToDTO(Attendancy attendancy);

}
