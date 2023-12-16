package com.rex.productionserver.controller;

import com.rex.productionserver.repo.LoginParam;
import com.rex.productionserver.repo.RespBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/usr")
public class LoginController {
    @RequestMapping("/")
    public RespBean login(LoginParam loginParam, HttpServletRequest request) {
        return RespBean.success("login success");
    }
}
