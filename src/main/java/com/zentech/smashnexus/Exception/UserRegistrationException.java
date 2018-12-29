package com.zentech.smashnexus.Exception;

public class UserRegistrationException extends Exception {
    public String getDetail() {
        return detail;
    }

    private String detail;
    public UserRegistrationException(String m){
        detail = m;
    }
}
