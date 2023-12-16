package com.rex.productionserver.repo;

import com.rex.productionserver.pojo.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("select * from user u where u.username = ${username}")
    public User findByName(String username);

    public Void saveUser(String username, String password);
}
