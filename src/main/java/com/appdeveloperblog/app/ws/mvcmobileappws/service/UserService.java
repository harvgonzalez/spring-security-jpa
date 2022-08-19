package com.appdeveloperblog.app.ws.mvcmobileappws.service;

import com.appdeveloperblog.app.ws.mvcmobileappws.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

     UserDto createUser(UserDto user);

     UserDto getUser(String email);
}
