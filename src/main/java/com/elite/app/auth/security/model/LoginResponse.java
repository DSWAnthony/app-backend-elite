package com.elite.app.auth.security.model;

public record LoginResponse(
        String accessToken,
        String refreshToken
) {
}
