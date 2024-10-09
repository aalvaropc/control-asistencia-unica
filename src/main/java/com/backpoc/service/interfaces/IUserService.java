package com.backpoc.service.interfaces;

import java.util.List;

import com.backpoc.persistence.entity.User;
import com.backpoc.presentation.dto.UserDTO;

public interface IUserService {
    UserDTO getUser(String username,String password);
}
