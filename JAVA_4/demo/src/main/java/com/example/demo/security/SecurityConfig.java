package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable() // 解决 csrf post 403 问题
                .authorizeRequests() // 3
                .antMatchers("/index", "/css/**", "/readingList").permitAll() //4
                .antMatchers("/user/**").hasRole("USER") //5
                .and()                // 6
                .formLogin()
                .loginPage("/login").failureUrl("/login-error");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { // 7
        auth
                .inMemoryAuthentication() //8
                .withUser("user").password("password").roles("USER") // 9
        .and()
                .passwordEncoder(new CustomPasswordEncoder());
    }

}
