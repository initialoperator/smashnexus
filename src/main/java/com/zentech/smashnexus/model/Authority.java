package com.zentech.smashnexus.model;

import org.springframework.data.annotation.Id;

import java.util.List;
//this class is obsolete
public class Authority{

    @Id
    private String id;

    private String role;;

    private List<String> privileges;

    private List<Long> userIds;


    public String getAuthority() {
        return this.role;
    }

    public Authority(String s){
        this.role = s;
    }
}
