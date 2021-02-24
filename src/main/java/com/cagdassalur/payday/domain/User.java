package com.cagdassalur.payday.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private long userId;

    private String email;

    private String password;

    @Column(name="user_name")
    private String userName;

    private boolean isEnabled;
}
