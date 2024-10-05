package com.backpoc.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.backpoc.persistence.entity.Faculty;
import com.backpoc.presentation.dto.FacultyDTO;

@Mapper(componentModel = "spring")
@Component
public interface FacultyMapper {

    FacultyMapper INSTANCE = Mappers.getMapper(FacultyMapper.class);

    FacultyDTO toDTO(Faculty faculty);

    Faculty toEntity(FacultyDTO facultyDTO);
}
