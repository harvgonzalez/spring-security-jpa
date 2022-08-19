package com.appdeveloperblog.app.ws.mvcmobileappws.entity;

import com.appdeveloperblog.app.ws.mvcmobileappws.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByEmail(String email); // this name actually references the  field email from UserEntity so i can't do findUserByEmailAdress because  adress isnt part of the name
}
