package com.eim;

import lombok.Getter;

/**
 * Created by Zy on 2018/12/24.
 */
@Getter
public enum ExceptionEnums {

    LOGIN_PARAM_ERROR(10,"登录表单参数错误"),
    USER_NOT_EXSIT(11,"用户不存在"),
    ;

    private Integer code;

    private String massage;

    ExceptionEnums() {
    }

    ExceptionEnums(Integer code, String massage) {
        this.code = code;
        this.massage = massage;
    }
}
