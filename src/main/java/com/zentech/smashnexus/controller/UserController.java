package com.zentech.smashnexus.controller;

import com.zentech.smashnexus.model.UserDetail;
import com.zentech.smashnexus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserDetail getUserById(@PathVariable Long id){
        return this.userService.getUserWithId(id);
    }

    @RequestMapping(value="/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public String saveUser(@RequestBody UserDetail userDetail){
        this.userService.saveUser(userDetail);
        return "Good!";
    }
}
