package com.springboot.lee.constants;

public enum UserStatus {
    NORMAL("0", "正常"),
    DISABLED("1", "停用");

    private final String code;
    private final String desc;

    UserStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}