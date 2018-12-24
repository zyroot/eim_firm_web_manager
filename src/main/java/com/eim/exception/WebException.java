package com.eim.exception;

import com.eim.ExceptionEnums;

/**
 * Created by Zy on 2018/12/24.
 */
public class WebException extends RuntimeException{

    private Integer code;

    private String massage;

    public WebException(ExceptionEnums enums){
        super(enums.getMassage());
        this.code = enums.getCode();
        this.massage = enums.getMassage();
    }

    public WebException(String message, Integer code) {
        super(message);
        this.code = code;
        this.massage = message;
    }
}
