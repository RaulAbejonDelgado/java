package com.raul.spring.jpa.springjpav1;

import com.raul.spring.jpa.springjpav1.auth.handler.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginSuccessHandler successHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private String USER_QUERY = "select username, password, enabled from users where username=?";
    private String USER_ROLE = "select u.username, a.authority from authorities a inner join users u on (a.user_id=u.id) where u.username=?";



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/","/css/**","/js/**","/images/**","/list/**").permitAll()
                .antMatchers("/show/**","/uploads/**").hasAnyRole("USER")
                .antMatchers("/form/**","/delete/**","/saleorder/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().successHandler(successHandler).loginPage("/login").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error_http")
        ;
    }

    /**
     * In memory
     */
//    @Autowired
//    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
//
//        PasswordEncoder encoder = passwordEncoder();
//
//        UserBuilder users = User.builder().passwordEncoder(password -> {
//            return encoder.encode(password);
//        });
//
//        builder.inMemoryAuthentication()
//                .withUser(users.username("admin").password("admin")
//                        .roles("ADMIN","USER"))
//                .withUser(users.username("drohne").password("drohne")
//                        .roles("USER"));
//
//    }

    /**
     * Jdbc authentication
     */
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
    {
        build.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder)
                .usersByUsernameQuery(USER_QUERY)
                .authoritiesByUsernameQuery(USER_ROLE);
    }
}
