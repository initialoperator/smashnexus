package com.zentech.smashnexus.controller;

import com.zentech.smashnexus.Exception.UserRegistrationException;
import com.zentech.smashnexus.model.User;
import com.zentech.smashnexus.service.IUserAuthService;
import com.zentech.smashnexus.viewobject.UserRegistratinVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private IUserAuthService userAuthService;

    @Autowired
    private PasswordEncoder encoder;

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable String id){
        return this.userAuthService.getUserWithId(id);
    }

    @RequestMapping(value="/registerUser", method = RequestMethod.POST)
    @ResponseBody
    public String registeruser(@RequestBody UserRegistratinVO user){
        try{
            User result = this.userAuthService.registerUser(user);
        }catch (UserRegistrationException e){
            String detail = e.getDetail();
            return detail;
        }

        return "Good!";
    }
}
