package com.example.cafe.Service;

import com.example.cafe.DTO.UserDto;

import com.example.cafe.Repository.RoleRepository;
import com.example.cafe.Repository.UserRepository;

import com.example.cafe.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void insert(UserDto userDto) {
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        Set<Role> rolesSet = new HashSet<Role>();
        rolesSet.add(roleRepository.findQneById(2L)); // id : 2 ROLE_USER 역할
        userRepository.save(userDto.toEntity(rolesSet));
    }
}
