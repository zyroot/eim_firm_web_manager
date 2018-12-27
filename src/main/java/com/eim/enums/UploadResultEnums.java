package com.eim.enums;

import lombok.Getter;

/**
 * Created by Zy on 2018/12/26.
 */
@Getter
public enum  UploadResultEnums {

    success(0,"上传成功"),
    error(1,"上传失败"),
    ;

    private Integer code;

    private String message;

    private UploadResultEnums() {
    }

    private UploadResultEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
