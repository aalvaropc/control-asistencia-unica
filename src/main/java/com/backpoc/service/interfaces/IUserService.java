package com.backpoc.service.interfaces;

import java.util.List;

import com.backpoc.presentation.dto.UserDTO;

public interface IUserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

}
