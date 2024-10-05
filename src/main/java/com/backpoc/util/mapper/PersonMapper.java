package com.backpoc.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.backpoc.persistence.entity.User;
import com.backpoc.presentation.dto.UserDTO;

@Mapper(componentModel = "spring")
@Component
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
}
