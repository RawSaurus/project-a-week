package com.rawsaurus.attendance_management_system.user;

import jakarta.annotation.Nonnull;

public record UserRequest(


        @Nonnull
        String firstname,
        @Nonnull
        String lastname,
        @Nonnull
        String email
) {
}
