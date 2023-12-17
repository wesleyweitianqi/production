package com.rex.productionserver.controller;

import com.rex.productionserver.config.JwtTokenUtil;
import com.rex.productionserver.pojo.LoginParam;
import com.rex.productionserver.pojo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/login")
    public String login() {
        return "login"; // Renders the login.html Thymeleaf template
    }


    @PostMapping("/login")
    public RespBean login(LoginParam loginParam, HttpServletRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        String token = null;
        if(loginParam.getPassword().equals(userDetails.getPassword())){
            token = jwtTokenUtil.generateToken(userDetails);
        }
        return RespBean.success("login success",token);
    }
}
