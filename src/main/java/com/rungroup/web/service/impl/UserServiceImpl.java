package com.rungroup.web.service.impl;

import com.rungroup.web.dto.RegistrationDto;
import com.rungroup.web.models.Role;
import com.rungroup.web.models.UserEntity;
import com.rungroup.web.repository.RoleRepository;
import com.rungroup.web.repository.UserRepository;
import com.rungroup.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user=new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role=roleRepository.findByName("USER");
        user.setRoles(Arrays.asList((role)));
        userRepository.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return null;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return null;
    }

}
