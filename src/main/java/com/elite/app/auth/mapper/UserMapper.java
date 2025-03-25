package com.elite.app.auth.mapper;


import com.elite.app.auth.entity.User;
import com.elite.app.auth.security.model.response.UserResponse;

public class UserMapper {


    public static UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .fecha_creacion(user.getFecha_creacion())
                .build();
    }

}
