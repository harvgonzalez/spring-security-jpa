package com.appdeveloperblog.app.ws.mvcmobileappws.shared;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable {

    private static final long serialVersionUID = -18871238536769847L;
    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encryptedPassword;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus = false;

}
