package com.eim.enums;

import lombok.Getter;

/**
 * Created by Zy on 2018/12/24.
 */
@Getter
public enum ExceptionEnums {

    LOGIN_PARAM_ERROR(10,"登录表单参数错误"),
    USER_NOT_EXSIT(11,"用户不存在"),
    H5_UPDATE_ERROE(12,"h5更新失败"),
    H5_SAVE_ERROE(13,"h5保存失败"),
    PARAMS_ERROE(15,"参数错误"),
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
