package com.backpoc.presentation.controller;

import java.util.List;

import com.backpoc.persistence.entity.User;
import com.backpoc.util.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backpoc.presentation.dto.UserDTO;
import com.backpoc.service.interfaces.IUserService;

import javax.annotation.processing.Generated;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public GenericResponse<UserDTO> login(@RequestBody UserDTO userDTO) {
    UserDTO isValidUser = userService.getUser(userDTO.getEmail(), userDTO.getPassword());
            if (isValidUser != null) {
                return GenericResponse.<UserDTO>builder()
                        .success(true)
                        .message("Login successful")
                        .data(isValidUser)
                        .build();
            }
            return GenericResponse.<UserDTO>builder()
                    .success(false)
                    .message("Invalid credentials")
                    .data(null)
                    .build();
    }
}
