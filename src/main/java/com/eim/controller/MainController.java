package com.eim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 主界面
 * Created by Zy on 2018/12/25.
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping("/index.do")
    public String index(HttpServletRequest request){
//        String username = (String) request.getSession().getAttribute("user");
        return "index";
    }

}
