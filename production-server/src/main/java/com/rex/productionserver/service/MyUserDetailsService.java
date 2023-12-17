package com.rex.productionserver.service;

import com.rex.productionserver.pojo.CustomUserDetails;
import com.rex.productionserver.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        if (null != user) {
            user.setRoles(userService.getRoles(user.getId()));
            return new CustomUserDetails(user);
//            }
        }
        throw new UsernameNotFoundException("username or password is wrong");
    }
}
