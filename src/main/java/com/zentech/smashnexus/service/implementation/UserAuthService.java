package com.zentech.smashnexus.service.implementation;

import com.zentech.smashnexus.Exception.UserRegistrationException;
import com.zentech.smashnexus.model.User;
import com.zentech.smashnexus.repository.UserAuthRepository;
import com.zentech.smashnexus.service.IUserAuthService;
import com.zentech.smashnexus.viewobject.UserRegistratinVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements IUserAuthService {

    public static final String USER_REGISTRATION_ERROR_USENAME_NOT_PROVIDED = "USERNAME_NOT_PROVIDED";
    public static final String USER_REGISTRATION_ERROR_USENAME_EXISTS = "USERNAME_EXISTS";
    public static final String USER_REGISTRATION_ERROR_PASSWORD_NOT_PROVIDED = "PASSWORD_NOT_PROVIDED";
    public static final String USER_REGISTRATION_ERROR_PASSWORD_REENTERED_NOT_PROVIDED = "PASSWORD_REENTERED_NOT_PROVIDED";
    public static final String USER_REGISTRATION_ERROR_PASSWORDS_NOT_MATCHED = "PASSWORDS_NOT_MATCHED";
    @Autowired
    private UserAuthRepository userAuthRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public User registerUser(UserRegistratinVO vo) throws UserRegistrationException {
        String result = this.validateUserRegistrationInfo(vo);
        if(result!= ""){
            throw new UserRegistrationException(result);
        }
        User model = new User();
        this.convertUserRegistrationVOToUser(vo, model);
        User result_user = this.saveUser(model);
        return result_user;
    }

    @Override
    public User saveUser(User user) {
        String password = user.getPassword();
        String passwordHased = this.encoder.encode(password);
        user.setPassword(passwordHased);
        User ud = this.userAuthRepository.save(user);
        return ud;
    }

    @Override
    public User getUserWithId(String userId) {
        return this.userAuthRepository.findById(userId).get();
    }

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        return this.userAuthRepository.findByUsername(s);
    }

    private String validateUserRegistrationInfo(UserRegistratinVO user){
        //whether username exist
        String username = user.getUsername();
        if(username == null || username.trim() == ""){
            return USER_REGISTRATION_ERROR_USENAME_NOT_PROVIDED;
        }
        User existingUser = this.loadUserByUsername(username);
        if(existingUser!= null){
            return USER_REGISTRATION_ERROR_USENAME_EXISTS;
        }
        String password = user.getPassword();
        if(password == null || password.trim() == ""){
            return USER_REGISTRATION_ERROR_PASSWORD_NOT_PROVIDED;
        }
        String passwordReentered = user.getPasswordReentered();
        if(passwordReentered == null || passwordReentered.trim() == ""){
            return USER_REGISTRATION_ERROR_PASSWORD_REENTERED_NOT_PROVIDED;
        }
        if(!password.equals(passwordReentered)){
            return USER_REGISTRATION_ERROR_PASSWORDS_NOT_MATCHED;
        }
        return "";
    }

    public void convertUserRegistrationVOToUser(UserRegistratinVO vo, User model){
        BeanUtils.copyProperties(vo, model);
    }
}
