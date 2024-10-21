package com.rawsaurus.attendance_management_system;

import com.rawsaurus.attendance_management_system.user.Role;
import com.rawsaurus.attendance_management_system.user.User;
import com.rawsaurus.attendance_management_system.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
public class AttendanceManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceManagementSystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository repository, PasswordEncoder passwordEncoder){
		return args ->{
			User admin = User.builder()
					.firstname("admin")
					.lastname("admin")
					.email("admin.mail@gmail.com")
					.password(passwordEncoder.encode("admin"))
					.role(Role.ADMIN)
					.build();

			repository.save(admin);
		};
	}

}
