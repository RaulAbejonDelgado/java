package com.raul.spring.microservices.oauth.clients;

import com.raul.spring.microservices.user.commons.models.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="service-user")
public interface UserFeingClient {

    @GetMapping("/users/search/findByUsername")
    public User findByUsername(@RequestParam String username);

}
