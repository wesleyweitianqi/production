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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="roles")
@ApiModel(value = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "roleId")
    private Integer id;
    @Column(name="name")
    @ApiModelProperty(value = "rolename")
    private String rolename;
    @ManyToMany(mappedBy = "roles")
    @ApiModelProperty(value = "users")
    private List<User> users;
}
