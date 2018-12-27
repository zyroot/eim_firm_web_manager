package com.eim.controller;

import com.eim.Vo.UploadImgVo;
import com.eim.enums.UploadResultEnums;
import com.eim.util.KeyUtil;
import com.eim.util.UploadImgVoUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * 文件上传控制器
 * Created by Zy on 2018/12/26.
 */
@Slf4j
@Controller
@RequestMapping("/upload")
public class UploadImgController {

    @ResponseBody
    @PostMapping("/img.do")
    public UploadImgVo uploadImg(@RequestParam("Img") MultipartFile file){

        String extension = FilenameUtils.getExtension(file.getOriginalFilename());

        //重置图片名字
        String imgName = KeyUtil.getUniKey()+"."+extension;
        //保存到数据库的字段
        String sqlPathName = "upload/"+imgName;
        //上传图片到服务器
        Client client = new Client();
            //发送的目的地
        String url = "http://www.ei-marketing.cn/web_save/"+sqlPathName;
            //上传
        WebResource resource = client.resource(url);
        try {
            resource.put(String.class,file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            //上传失败
            log.error("【图片上传】 文件上传失败");
            return UploadImgVoUtil.error();
        }
        //返回图片的url
        return UploadImgVoUtil.success(sqlPathName,url);

    }
}
