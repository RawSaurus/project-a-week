package com.rawsaurus.attendance_management_system.admin;

import com.rawsaurus.attendance_management_system.user.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponse findUser(String email){
        return userMapper.toResponse(userRepository.findByEmail(email)
                .orElse(null));
    }
    public UserResponse generateNewUserCredentials(UserRequest request){

        String password = generatePassword();
        User user = userMapper.toEntity(request);
        user.setPassword(password);
        user.setRole(Role.USER);

        userRepository.save(user);

        return userMapper.toResponse(user);
    }

    public UserResponse updateUser(UserRequest userRequest, String email, String newPassword){

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        user.setFirstname(userRequest.firstname());
        user.setLastname(userRequest.lastname());
        user.setEmail(userRequest.email());
        if(!newPassword.isEmpty())
            user.setPassword(newPassword);

        return userMapper.toResponse(userRepository.save(user));
    }

    public void deleteUser(String email){

        userRepository.deleteByEmail(email);
    }

    private String generatePassword(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i<11; i++){
            char c = (char) random.nextInt(33, 126);
            sb.append(c);
        }
        return sb.toString();
    }
}
