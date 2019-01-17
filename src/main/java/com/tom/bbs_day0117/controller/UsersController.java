package com.tom.bbs_day0117.controller;

import com.bilibili.yl.util.MD5Utils;
import com.tom.bbs_day0117.constants.ResultEntity;
import com.tom.bbs_day0117.constants.ResultEnum;
import com.tom.bbs_day0117.model.Users;
import com.tom.bbs_day0117.service.UsersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Resource
    private UsersService usersServiceImpl;

    @RequestMapping("/login")
    public ResultEntity<String> login(Users users, HttpSession session) {
        ResultEntity<String> result = new ResultEntity<>();
        try {
            users.setPassword(MD5Utils.MD5Encode(users.getPassword(), "utf-8"));
            Users isExist = usersServiceImpl.login(users);
            if (isExist != null) {
                session.setAttribute("user", isExist);
                result.setCodeAndMsg(ResultEnum.LOGIN_SUCCESS_MESS);
            } else {
                result.setCodeAndMsg(ResultEnum.LOGIN_FAILED_MESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCodeAndMsg(ResultEnum.SYSTEM_INNER_ERROR);
        }
        return result;
    }
}
