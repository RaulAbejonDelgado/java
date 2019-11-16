package com.raul.spring.microservices.oauth.services;

import com.raul.spring.microservices.user.commons.models.entity.User;

public interface IUserService {

    public User findByUsername(String username);
}
