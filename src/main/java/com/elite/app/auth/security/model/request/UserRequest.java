package com.elite.app.auth.security.model.request;


public record UserRequest(
        String username,
        String password
) {
}
