package com.rex.productionserver.service;

import com.rex.productionserver.repo.RespBean;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    RespBean login(String name, String password, HttpServletRequest request);
}
