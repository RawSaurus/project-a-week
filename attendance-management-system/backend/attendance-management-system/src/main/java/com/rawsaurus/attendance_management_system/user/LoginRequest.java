package com.rawsaurus.attendance_management_system.user;

public record LoginRequest(
        String email,
        String password
) {
}
