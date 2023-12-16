package com.rex.productionserver.service.impl;

import com.rex.productionserver.repo.RespBean;
import com.rex.productionserver.repo.UserRepo;
import com.rex.productionserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserRepo userRepo;

    @Override
    public RespBean login(String name, String password, HttpServletRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(name);
        if (null == userDetails) {
            return RespBean.error("username or password is wrong");
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
                null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return null;
    }

}
