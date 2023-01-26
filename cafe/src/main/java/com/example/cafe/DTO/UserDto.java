package com.example.cafe.DTO;

import java.util.Set;
import com.example.cafe.model.Role;
import com.example.cafe.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String id;

    private String password;

    private String name;

    private Set<Long> roles;

    public User toEntity(Set<Role> roles) {
        return User.builder().id(id).password(password).name(name).roles(roles).build();
    }
}