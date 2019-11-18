package com.raul.spring.microservices.oauth.security.event;

import brave.Tracer;
import com.raul.spring.microservices.oauth.services.IUserService;
import com.raul.spring.microservices.user.commons.models.entity.User;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

    Logger log = LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private Tracer tracer;

    @Override
    public void publishAuthenticationSuccess(Authentication authentication) {
        User u = userService.findByUsername(authentication.getName());
        u.setLoggingTries(0);
        userService.update(u,u.getId());
        log.info(String.format("Authentication Success for user : %s , with Role : %s",u.getUsername(), u.getRoles()));
    }

    @Override
    public void publishAuthenticationFailure(AuthenticationException e, Authentication authentication) {
        StringBuilder errors = new StringBuilder();

        try{
            User u = userService.findByUsername(authentication.getName());
            u.setLoggingTries(u.getLoggingTries()+1);
            if(u.getLoggingTries() >= 3) {
                u.setEnabled(false);
            }
            userService.update(u,u.getId());
            log.error(String.format("Error publishAuthenticationFailure : %s, the user %s, are tried %d times logging", e.getMessage(),u.getUsername(),u.getLoggingTries()));
            errors.append(String.format("Error publishAuthenticationFailure : %s, the user %s, are tried %d times logging", e.getMessage(),u.getUsername(),u.getLoggingTries()));
            tracer.currentSpan().tag(" Errors:", errors.toString());
        }catch (FeignException ex){
            log.error(ex.getMessage());
            errors.append(String.format("Catching error: %s",ex.getMessage()));
            tracer.currentSpan().tag("Errors:" , errors.toString());
        }

    }
}

