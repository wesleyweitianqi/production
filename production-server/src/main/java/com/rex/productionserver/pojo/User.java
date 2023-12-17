package com.rex.productionserver.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer id;

     @Column(name="username")
     private String username;
     @Column(name="password")
     private String password;

     @ManyToMany(fetch = FetchType.EAGER) // Assuming roles are eagerly fetched
     @JoinTable(
             name = "user_roles",
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id")
     )
     private List<Role> roles;
}
