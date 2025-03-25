package com.elite.app.auth.security.model;

public record LoginRequest (
        String username,
        String password
){
}
