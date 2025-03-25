package com.elite.app.auth.security.model;

public record RegisterRequest(
        String username,
        String password
) {
}
