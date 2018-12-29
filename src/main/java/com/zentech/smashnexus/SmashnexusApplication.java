package com.zentech.smashnexus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SmashnexusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmashnexusApplication.class, args);
    }


//    @Bean
//    public PasswordEncoder myEncoder(){
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        return encoder;
//    }

    @Bean
    public BCryptPasswordEncoder safeEncoder(){
        return new BCryptPasswordEncoder();
    }

}

