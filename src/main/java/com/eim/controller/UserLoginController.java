package com.eim.controller;

import com.eim.Vo.ResultVo;
import com.eim.dataObject.User;
import com.eim.exception.WebException;
import com.eim.service.UserLoginService;
import com.eim.util.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @ResponseBody
    @PostMapping("/dologin.do")
    public ResultVo dologin(User user, HttpServletRequest request, Map map){
        try {
            userLoginService.checkUser(user);
        } catch (WebException e) {
            e.printStackTrace();
            return ResultVoUtil.error();
        }
        request.getSession().setAttribute("user",user.getName());
        return ResultVoUtil.success();
    }

}
