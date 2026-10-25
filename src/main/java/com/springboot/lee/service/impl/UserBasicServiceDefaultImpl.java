package com.springboot.lee.service.impl;

import org.springframework.stereotype.Service;

import com.springboot.lee.domain.ResponseResult;

@Service("userBasicServiceDefaultImpl")
public class UserBasicServiceDefaultImpl extends UserBasicServiceImpl {

    @Override
    public ResponseResult validateUser(String userInfo, String action) {
        throw new UnsupportedOperationException(
            "請使用專門的帳號或 Email 驗證服務"
        );
    }
}
