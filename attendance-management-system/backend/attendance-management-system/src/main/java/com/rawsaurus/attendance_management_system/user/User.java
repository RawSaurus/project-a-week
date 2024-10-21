package com.rawsaurus.attendance_management_system.user;

import com.rawsaurus.attendance_management_system.attendance.Attendance;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="_user")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @CreatedDate
    @Column(nullable = false, updatable = false)
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false, updatable = false)
//    @DateTimeFormat(pattern="yyyyMMdd")
    private LocalDateTime lastModifiedDate;

    @ManyToMany
    @JoinTable(
            name = "_users_attendance",
            joinColumns = @JoinColumn(name="userId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="attendanceId", referencedColumnName = "attendanceId")
    )
    private List<Attendance> attendances;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = role.getPermissions()
                        .stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));

        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
