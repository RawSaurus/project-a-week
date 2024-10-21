package com.rawsaurus.attendance_management_system.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public HttpStatus login(LoginRequest request){

        User user = userRepository.findByEmail(request.email())
                .orElse(null);
        if(user==null){
            return HttpStatus.NOT_FOUND;
        }

        if(request.password().equals(user.getPassword()))
            return HttpStatus.UNAUTHORIZED;

        return HttpStatus.ACCEPTED;

    }


}
