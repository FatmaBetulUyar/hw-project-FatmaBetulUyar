package com.patika.paycore.Project.security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

public class JwtTokenFilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilterConfigurer(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider=jwtTokenProvider;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}
