package com.raul.spring.microservices.oauth.services;

import com.raul.spring.microservices.oauth.clients.UserFeingClient;
import com.raul.spring.microservices.user.commons.models.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService ,UserDetailsService {

    private Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeingClient feingClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = feingClient.findByUsername(username);

        if(user == null){
            log.error(String.format("Error in the login, the user %s not exists",username));
            throw new UsernameNotFoundException("User not exists.");
        }

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .peek(authoritie -> log.info(String.format("Role: %s",authoritie.getAuthority())))
                .collect(Collectors.toList());
        log.info(String.format("User authenticated: ",user.getName()));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                true,
                true,
                true,
                authorities);
    }

    @Override
    public User findByUsername(String username) {
        return feingClient.findByUsername(username);
    }

    @Override
    public User update(User user, Long id) {
        return feingClient.update(user,id);
    }
}
