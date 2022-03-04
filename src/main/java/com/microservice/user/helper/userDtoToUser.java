package com.microservice.user.helper;

import com.microservice.user.entity.User;
import com.microservice.user.userDTO.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class userDtoToUser {
    public User convertUserDtoToUser(UserDTO userDTO){
     User user=  new User();
     user.setName(userDTO.getName());
     user.setDOB(userDTO.getDOB());
     user.setVoterId((userDTO.getVoterId()));

     return  user;

    }
}
