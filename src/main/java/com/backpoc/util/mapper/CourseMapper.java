package com.backpoc.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.backpoc.persistence.entity.Course;
import com.backpoc.presentation.dto.CourseDTO;

@Mapper(componentModel = "spring")
@Component
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDTO toDTO(Course course);

    Course toEntity(CourseDTO courseDTO);
}
