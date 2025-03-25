package com.elite.app.auth.security.service;

import com.elite.app.auth.security.jwt.JwtUtils;
import com.elite.app.auth.security.model.LoginRequest;
import com.elite.app.auth.security.model.LoginResponse;
import com.elite.app.auth.security.model.RegisterRequest;
import com.elite.app.auth.security.model.UserAuth;
import com.elite.app.auth.security.model.response.UserDto;
import com.elite.app.auth.security.model.response.UserResponse;
import com.elite.app.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;


    public UserDto registerUser(RegisterRequest request){
        UserDto resp = new UserDto();

        try {
            UserResponse userSaved = userService.registerUser(request);
            if (userSaved.getId()!=null){
                resp.setUser(userSaved);
                resp.setMessage("User Saved Successfully");
                resp.setStatusCode(200);
            }


        }catch (Exception e){
            resp.setStatusCode(500);
            resp.setError(e.getLocalizedMessage());
        }
        return resp;
    }

    public LoginResponse login(LoginRequest loginRequest){
        Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(),loginRequest.password()));


        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserAuth userDetails = (UserAuth) authentication.getPrincipal();

        String accessToken = jwtUtils.generateTokenForUser(userDetails);
        String refreshToken = jwtUtils.generateRefreshTokenForUser(userDetails);

        return new LoginResponse(accessToken,refreshToken);
    }
}
