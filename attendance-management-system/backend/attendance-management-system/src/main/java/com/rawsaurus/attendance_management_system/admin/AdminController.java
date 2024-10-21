package com.rawsaurus.attendance_management_system.admin;

import com.rawsaurus.attendance_management_system.user.UserRequest;
import com.rawsaurus.attendance_management_system.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('admin')")
public class AdminController {

    private final AdminService adminService;

    @GetMapping
    public ResponseEntity<UserResponse> findUser(@RequestBody String email){
        return ResponseEntity.ok(adminService.findUser(email));
    }
    @PostMapping
    public ResponseEntity<UserResponse> generateNewUserCredentials(@RequestBody @Validated UserRequest userRequest){
        return ResponseEntity.ok(adminService.generateNewUserCredentials(userRequest));
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest, @RequestBody String email, @RequestBody String newPassword){
        return ResponseEntity.ok(adminService.updateUser(userRequest, email, newPassword));
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestBody String email){
        adminService.deleteUser(email);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
