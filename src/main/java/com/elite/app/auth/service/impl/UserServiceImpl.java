package com.elite.app.auth.service.impl;

//import com.barber.elvis.auth.entity.Role;
//import com.barber.elvis.auth.entity.User;
//import com.barber.elvis.auth.mapper.UserMapper;
//import com.barber.elvis.auth.model.request.UserRequest;
//import com.barber.elvis.auth.model.response.UserResponse;
//import com.barber.elvis.auth.repository.RoleRepository;
//import com.barber.elvis.auth.repository.UserRepository;
//import com.barber.elvis.auth.security.model.RegisterRequest;
//import com.barber.elvis.auth.service.UserService;
//import com.barber.elvis.core.dto.customer.CustomerRequest;
//import com.barber.elvis.core.dto.customer.CustomerResponse;
//import com.barber.elvis.core.dto.staff.StaffResponse;
//import com.barber.elvis.core.service.CustomerService;
//import com.barber.elvis.core.service.StaffService;
import com.elite.app.auth.entity.User;
import com.elite.app.auth.mapper.UserMapper;
import com.elite.app.auth.repository.UserRepository;
import com.elite.app.auth.security.model.RegisterRequest;
import com.elite.app.auth.security.model.request.UserRequest;
import com.elite.app.auth.security.model.response.UserResponse;
import com.elite.app.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse getUser(UUID id) {
        return userRepository.findById(id)
                .map(UserMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Use not exist"));
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream().map(UserMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse registerUser(RegisterRequest register) {

        User user = User.builder()
                        .username(register.username())
                        .password(passwordEncoder.encode(register.password()))
                        .build();

        User userSaved = userRepository.save(user);

        return UserMapper.toResponse(userSaved);

    }

    @Override
    public UserResponse updateUser(UUID id, UserRequest user) {

        return userRepository.findById(id)
                .map(userEntity -> {
                    userEntity.setUsername(user.username());
                    userEntity.setPassword(user.password());

                    return UserMapper.toResponse(userEntity);
                }).orElseThrow(() -> new RuntimeException("User not Exist"));
    }

    @Override
    public Boolean deleteUser(UUID id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(""));

        if (user !=null){
            userRepository.delete(user);
            return true;
        }
        return false;
    }
}
