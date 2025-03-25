package com.elite.app.auth.security.model;

import com.elite.app.auth.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter @Setter @Builder
public class UserAuth implements UserDetails {

    private UUID id;
    private String email;
    private String username;
    private String password;


    public static UserAuth toUserAuth(User user){
        return UserAuth.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }


}
