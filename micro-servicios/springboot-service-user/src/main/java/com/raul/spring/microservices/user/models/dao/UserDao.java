package com.raul.spring.microservices.user.models.dao;

import com.raul.spring.microservices.user.models.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "users")
public interface UserDao extends PagingAndSortingRepository<User, Long> {

    /**
     * @RestResource(path="name endopoint")
     * @Query("select u from User u where u.username=?1)
     */
    public User findByUsername(@Param("username")String userName);


}
