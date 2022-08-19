package com.appdeveloperblog.app.ws.mvcmobileappws.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {


    private static final long serialVersionUID = -4588389278596674786L;
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable=false)
    private String userId;

    @Column(nullable=false, length=50)
    private String firstName;

    @Column(nullable=false, length=50)
    private String lastName;

    @Column(nullable=false, length=120)
    private String email;

    @Column(nullable=false)
    private String encryptedPassword;

    private String emailVerificationToken;

    @Column(nullable=false)
    private Boolean emailVerificationStatus = false;


}