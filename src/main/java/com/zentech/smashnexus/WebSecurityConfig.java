package com.zentech.smashnexus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests().antMatchers("/config").permitAll()
                .and()
            .authorizeRequests().antMatchers("/**").hasRole("USER").and().httpBasic();



        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {

        authManagerBuilder
                .inMemoryAuthentication()
                .withUser("user").password(encoder.encode("password")).roles("USER");
    }

}
