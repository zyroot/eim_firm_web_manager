package com.eim.exception;

import com.eim.enums.ExceptionEnums;

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

    public WebException( Integer code,String message) {
        super(message);
        this.code = code;
        this.massage = message;
    }
}
