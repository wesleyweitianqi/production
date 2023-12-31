package com.rex.productionserver.service.impl;

import com.rex.productionserver.pojo.RespBean;
import com.rex.productionserver.pojo.Role;
import com.rex.productionserver.pojo.User;
import com.rex.productionserver.repo.UserRepo;
import com.rex.productionserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserDetailsService userDetailsService;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

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

    @Override
    public List<Role> getRoles(Integer id) {
        return userRepo.getRoles(id);
    }

}
