package com.rawsaurus.attendance_management_system.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Getter
@AllArgsConstructor
public enum Role {
    ADMIN(List.of("admin", "user")),
    USER(List.of("user"));

    private final List<String> permissions;
}

