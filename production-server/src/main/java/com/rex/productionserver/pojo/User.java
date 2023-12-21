package com.rex.productionserver.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "users")
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @ApiModelProperty(value = "id")
     private Integer id;

     @Column(name="username")
     @ApiModelProperty(value = "username")
     private String username;

     @ApiModelProperty(value="password")
     @Column(name="password")
     private String password;

     @Column(name="email")
     @ApiModelProperty(value = "email")
     private String email;

     @ApiModelProperty(value="roles")
     @ManyToMany(fetch = FetchType.EAGER) // Assuming roles are eagerly fetched
     @JoinTable(
             name = "user_role",
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id")
     )
     private List<Role> roles;
}
