package com.rawsaurus.attendance_management_system.attendance;

import com.rawsaurus.attendance_management_system.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attendance {

    @Id
    @GeneratedValue
    private Long attendanceId;

    private LocalDateTime checkedIn;
    private LocalDateTime checkedOut;

    @ManyToMany
    @JoinTable(
            name = "_users_attendance",
            joinColumns = {@JoinColumn(name="attendanceId", referencedColumnName = "attendanceId")},
            inverseJoinColumns = @JoinColumn(name="userId", referencedColumnName = "id")
    )
    private List<User> users;
}
