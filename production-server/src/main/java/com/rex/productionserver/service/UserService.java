package com.rex.productionserver.service;

import com.rex.productionserver.pojo.RespBean;
import com.rex.productionserver.pojo.Role;
import com.rex.productionserver.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    User getUserByUsername(String username);
    RespBean login(String name, String password, HttpServletRequest request);

    List<Role> getRoles(Integer id);
}
