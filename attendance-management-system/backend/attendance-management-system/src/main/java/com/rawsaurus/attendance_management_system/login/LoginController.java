package com.rawsaurus.attendance_management_system.login;

import com.rawsaurus.attendance_management_system.user.LoginRequest;
import com.rawsaurus.attendance_management_system.user.UserRepository;
import com.rawsaurus.attendance_management_system.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping
    public HttpStatus login(LoginRequest loginRequest){
        return userService.login(loginRequest);
    }
}
