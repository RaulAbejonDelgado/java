package com.raul.spring.microservices.oauth.clients;

import com.raul.spring.microservices.user.commons.models.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="service-user")
public interface UserFeingClient {

    @GetMapping("/users/search/findByUsername")
    public User findByUsername(@RequestParam String username);

    @PutMapping("/users/{id}")
    public User update(@RequestBody User user, @PathVariable Long id);

}
