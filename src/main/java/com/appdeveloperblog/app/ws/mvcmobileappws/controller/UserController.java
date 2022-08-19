package com.appdeveloperblog.app.ws.mvcmobileappws.controller;

import com.appdeveloperblog.app.ws.mvcmobileappws.model.request.UserDetailsRequestModel;
import com.appdeveloperblog.app.ws.mvcmobileappws.model.response.UserRest;
import com.appdeveloperblog.app.ws.mvcmobileappws.service.UserService;
import com.appdeveloperblog.app.ws.mvcmobileappws.shared.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public  String getUser(){
        return "get user";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){

        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);


        return returnValue;
    }

    @PutMapping
    public String updateUser(){
        return "update";
    }

    @DeleteMapping
    public  String deleteUser(){
        return "delete users";
    }
}
