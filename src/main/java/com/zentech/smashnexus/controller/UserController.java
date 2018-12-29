package com.zentech.smashnexus.controller;

import com.zentech.smashnexus.model.User;
import com.zentech.smashnexus.service.IUserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private IUserAuthService userService;

    @Autowired
    private PasswordEncoder encoder;

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable String id){
        return this.userService.getUserWithId(id);
    }

    @RequestMapping(value="/registerUser", method = RequestMethod.POST)
    @ResponseBody
    public String registeruser(@RequestBody User user){
        String user1Encoded = this.encoder.encode("user1");
        User result = this.userService.saveUser(user);
        return "Good!";
    }
}
