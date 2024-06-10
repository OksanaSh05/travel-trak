package com.dyplom.travel.models.user;

import com.dyplom.travel.models.BaseEntity;
import com.dyplom.travel.models.TripTicket;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {
    @NotBlank
    @Basic
    private String username;

    @NotBlank
    @Basic
    private String password;

    @NotBlank
    @Basic
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role = UserRole.ROLE_USER;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    private List<TripTicket> tripTickets;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(role);
    }
}
