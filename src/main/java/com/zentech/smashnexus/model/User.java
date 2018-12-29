package com.zentech.smashnexus.model;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class User implements UserDetails {
    @Id
    private String userId;

    private String username;

    private String password;

    private Boolean expired;//later maybe refactored into expiry date

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    @Override
//    public Collection<GrantedAuthority> getAuthorities() {//TODO: for now it's using hardcoded privileges and will need to be backed by database
//        SimpleGrantedAuthority[] auths = new SimpleGrantedAuthority[]{new SimpleGrantedAuthority("READ"), new SimpleGrantedAuthority("WRITE") };
//        return Arrays.asList(auths);
//    }

    @Override
    public final Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> privileges = new ArrayList<>();
        privileges.add("READ");
        privileges.add("WRITE");
        return getGrantedAuthorities(privileges);
    }
    private final List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (final String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
