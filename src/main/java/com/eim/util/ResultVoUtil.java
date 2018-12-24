package com.eim.util;

import com.eim.Vo.ResultVo;
import lombok.Data;

/**
 * Created by Zy on 2018/12/24.
 */
public class ResultVoUtil {

    public static ResultVo success(Object data){
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(data);
        return resultVo;
    }
    public static ResultVo success(){
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(null);
        return resultVo;
    }
    public static ResultVo error(){
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setCode(1);
        resultVo.setMsg("失败");
        resultVo.setData(null);
        return resultVo;
    }
}
