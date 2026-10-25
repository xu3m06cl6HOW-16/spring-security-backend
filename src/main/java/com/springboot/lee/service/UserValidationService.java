package com.springboot.lee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.lee.domain.ResponseResult;
import com.springboot.lee.service.impl.UserBasicServiceImpl;

@Service
public class UserValidationService {
	
	@Autowired
    @Qualifier("userNameVerificationImpl")
    private UserBasicServiceImpl userNameVerification;

    @Autowired
    @Qualifier("userEmailVerificationImpl")
    private UserBasicServiceImpl emailVerification;

    public ResponseResult validateUserName(String userName, String action) {
        return userNameVerification.validateUser(userName, action);
    }

    public ResponseResult validateEmail(String email, String action) {
        return emailVerification.validateUser(email, action);
    }

}
