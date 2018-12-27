package com.eim.Vo;

import lombok.Data;

import java.util.List;

/**
 * Created by Zy on 2018/12/25.
 */
@Data
public class AjaxTableResultVo<T> {

    private long total;

    private List<T> rows;


}
