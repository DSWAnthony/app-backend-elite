package com.elite.app.auth.service;

import com.elite.app.auth.security.model.RegisterRequest;
import com.elite.app.auth.security.model.request.UserRequest;
import com.elite.app.auth.security.model.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponse getUser(UUID id);
    List<UserResponse> getAllUsers();

    UserResponse registerUser(RegisterRequest register);

    UserResponse updateUser(UUID id, UserRequest user);
    Boolean deleteUser(UUID id);

}
