package com.appdeveloperblog.app.ws.mvcmobileappws.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRest {
    private String userId; // this is done  so that mailicious people cannot guess
    private String firstName;
    private String lastName;
    private String email;
}
