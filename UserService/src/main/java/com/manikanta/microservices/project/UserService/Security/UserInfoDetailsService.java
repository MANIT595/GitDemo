package com.manikanta.microservices.project.UserService.Security;

import com.manikanta.microservices.project.UserService.Entity.User;
import com.manikanta.microservices.project.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        return user.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("username not Found"));

    }

}
