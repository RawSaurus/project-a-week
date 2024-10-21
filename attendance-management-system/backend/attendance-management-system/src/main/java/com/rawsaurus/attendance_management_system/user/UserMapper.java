package com.rawsaurus.attendance_management_system.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequest request){
        if(request==null)
            return null;
        return User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();
    }
    public User toEntity(UserResponse response){
        if(response==null)
            return null;
        return User.builder()
                .firstname(response.firstname())
                .lastname(response.lastname())
                .email(response.email())
                .password(response.password())
                .build();
    }

    public UserRequest toRequest(User user){
        if(user==null)
            return null;
        return new UserRequest(
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        );
    }

    public UserResponse toResponse(User user){
        if(user==null)
            return null;
        return new UserResponse(
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
