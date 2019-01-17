package com.tom.bbs_day0117.model;


import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "mail")
    private String mail;
    @Column(name = "address")
    private String address;
    @Column(name = "isAdmin")
    private Integer isAdmin;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "img")
    private String img;


}
