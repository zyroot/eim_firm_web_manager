package com.eim.Vo;

import lombok.Data;

/**
 * Created by Zy on 2018/12/24.
 */
@Data
public class ResultVo<T>{

    private Integer code;

    private String msg;

    private T data;
}
