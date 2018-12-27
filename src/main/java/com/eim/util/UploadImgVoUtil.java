package com.eim.util;

import com.eim.Vo.UploadImgVo;
import com.eim.enums.UploadResultEnums;

/**
 * Created by Zy on 2018/12/26.
 */
public class UploadImgVoUtil {

    public static UploadImgVo success(String img,String url){
        UploadImgVo uploadImgVo = new UploadImgVo();
        uploadImgVo.setFlog(UploadResultEnums.success.getCode());
        uploadImgVo.setImg(img);
        uploadImgVo.setUrl(url);
        return uploadImgVo;
    }
    public static UploadImgVo error(){
        UploadImgVo uploadImgVo = new UploadImgVo();
        uploadImgVo.setFlog(UploadResultEnums.error.getCode());
        return uploadImgVo;
    }
}
