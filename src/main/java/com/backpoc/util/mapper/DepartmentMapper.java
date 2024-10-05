package com.backpoc.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.backpoc.persistence.entity.Department;
import com.backpoc.presentation.dto.DepartmentDTO;

@Mapper(componentModel = "spring")
@Component
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDTO toDTO(Department department);

    Department toEntity(DepartmentDTO departmentDTO);
}
