package com.backpoc.service.implementation;

import com.backpoc.util.mapper.FacultyMapper;
import com.backpoc.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backpoc.persistence.entity.User;
import com.backpoc.persistence.repository.UserRepository;
import com.backpoc.presentation.dto.UserDTO;
import com.backpoc.service.interfaces.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDTO getUser(String email,String password) {
        User user = userRepository.findByEmailAndPassword(email,password);
        return userMapper.toDTO(user);
    }
}
