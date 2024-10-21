package com.rawsaurus.attendance_management_system.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('user')")
public class UserController {

    private final UserService userService;

    @GetMapping("/app/welcome")
    public void welcome(){
        System.out.println("hello");
    }

}
