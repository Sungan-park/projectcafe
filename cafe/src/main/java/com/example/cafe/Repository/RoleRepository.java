package com.example.cafe.Repository;


import com.example.cafe.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findQneById(Long id);
}
