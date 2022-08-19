package com.appdeveloperblog.app.ws.mvcmobileappws.service;

import com.appdeveloperblog.app.ws.mvcmobileappws.entity.UserRepository;
import com.appdeveloperblog.app.ws.mvcmobileappws.entity.UserEntity;
import com.appdeveloperblog.app.ws.mvcmobileappws.shared.UserDto;
import com.appdeveloperblog.app.ws.mvcmobileappws.shared.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user) {
        // check if exists
        if( userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists");

        // new instance  of user entity
        UserEntity userEntity = new UserEntity();

        //  copies the  data from user dto
        BeanUtils.copyProperties(user, userEntity);

        // Geneerates random alphanumeric userId
        String publicUserId = utils.generateUserId(30);
        userEntity.setUserId(publicUserId);

        // Sets  encoded password in DB
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        // savees in variable the stored data
        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto  returnValue = new UserDto();

        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }

    @Override
    public UserDto getUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);

        if( userEntity == null) throw new UsernameNotFoundException(email);

        UserDto  returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return  returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(email);

        if( userEntity == null) throw new UsernameNotFoundException(email);


        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }
}
