package com.eim.util;

import com.eim.Vo.AjaxTableResultVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Zy on 2018/12/25.
 */
@Component
public class AjaxTableResultVoUtil<T> {

    public  String getResult(long total, List<T> rows){
        AjaxTableResultVo<T> objectAjaxTableResultVo = new AjaxTableResultVo<>();
        objectAjaxTableResultVo.setTotal(total);
        objectAjaxTableResultVo.setRows(rows);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();
        return gson.toJson(objectAjaxTableResultVo);
    }


}
