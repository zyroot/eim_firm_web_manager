package com.eim.controller;

import com.eim.ExceptionEnums;
import com.eim.dataObject.User;
import com.eim.exception.WebException;
import com.eim.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.security.provider.MD5;

import java.util.Map;

/**
 * 登录前端控制器
 * Created by Zy on 2018/12/24.
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @GetMapping("/login.do")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/dologin.do")
    public String dologin(User user, Map map){
        try {
            userLoginService.checkUser(user);
        } catch (WebException e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
            map.put("url","/user/login.do");
            return "common/error";
        }
        return "redirect:/main/index.do";
    }

}
