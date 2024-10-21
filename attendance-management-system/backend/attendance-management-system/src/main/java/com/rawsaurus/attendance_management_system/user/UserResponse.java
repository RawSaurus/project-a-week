package com.rawsaurus.attendance_management_system.user;

import java.time.LocalDateTime;
import java.util.Date;

public record UserResponse(
        String firstname,
        String lastname,
        String email,
        String password
) {
}
