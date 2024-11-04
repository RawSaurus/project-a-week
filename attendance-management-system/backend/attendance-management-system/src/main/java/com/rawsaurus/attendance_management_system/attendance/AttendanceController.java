package com.rawsaurus.attendance_management_system.attendance;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
@PreAuthorize("hasAuthority('user')")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;


    @PostMapping("/check-in")
    public void checkIn(Authentication user){
        attendanceService.checkIn(user);
    }

    @PostMapping("/check-off")
    public void checkOff(Authentication user){
        attendanceService.checkOff(user);
    }
}
