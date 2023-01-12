package com.example.cafe.Service;

import com.example.cafe.Repository.UserRepository;
import com.example.cafe.model.Role;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
        private final UserRepository userRepository;

        @Override
        @Transactional(readOnly = true)
        public UserDetails loadUserByUsername(String id) {

                Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
                com.example.cafe.model.User user = userRepository.findOneById(id);

                if (user != null) {
                        for (Role role : user.getRoles()) {
                                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName())); // DB에 저장되어 있는 권한을 부여한다.
                        }
                        return new User(user.getId(), user.getPassword(), grantedAuthorities);
                } else {
                        throw new UsernameNotFoundException("can not find User : " + id);
                }
        }
}