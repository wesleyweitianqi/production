package com.rex.productionserver.repo;

import com.rex.productionserver.pojo.Role;
import com.rex.productionserver.pojo.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Query("SELECT u.roles FROM User u WHERE u.id = :userId")
    List<Role> getRoles(@Param("userId") Integer id);
}
