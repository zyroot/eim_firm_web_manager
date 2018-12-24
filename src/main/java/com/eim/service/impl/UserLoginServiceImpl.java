package com.eim.service.impl;

import com.eim.ExceptionEnums;
import com.eim.dataObject.User;
import com.eim.exception.WebException;
import com.eim.repository.UserRepository;
import com.eim.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Zy on 2018/12/24.
 */
@Slf4j
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean checkUser(User user) {
        if(StringUtils.isEmpty(user.getName())){
            log.error("【用户登录】 用户名不能为空 userName={}",user.getName());
            throw new WebException(ExceptionEnums.LOGIN_PARAM_ERROR);
        }
        if(StringUtils.isEmpty(user.getName())){
            log.error("【用户登录】 用户密码不能为空 password={}",user.getPassword());
            throw new WebException(ExceptionEnums.LOGIN_PARAM_ERROR);
        }
        User chckUser = userRepository.findByNameAndAndPassword(user.getName(), user.getPassword());
        if(chckUser == null){
            log.error("【用户登录】 用户不存在 user={}",chckUser);
            throw new WebException(ExceptionEnums.USER_NOT_EXSIT);
        }
        return true;
    }
}
