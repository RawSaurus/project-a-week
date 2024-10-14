package com.rawsaurus.attendance_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/app/welcome")
    public void welcome(){
        System.out.println("hello");
    }
}
