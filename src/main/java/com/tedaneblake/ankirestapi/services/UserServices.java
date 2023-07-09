package com.tedaneblake.ankirestapi.services;

import com.tedaneblake.ankirestapi.DTOs.LoginDTO;
import com.tedaneblake.ankirestapi.DTOs.UserDTO;
import com.tedaneblake.ankirestapi.exceptions.ObjectNotFoundException;
import com.tedaneblake.ankirestapi.exceptions.RequiredFieldMissingException;
import com.tedaneblake.ankirestapi.exceptions.UnauthorizedException;
import com.tedaneblake.ankirestapi.models.User;
import com.tedaneblake.ankirestapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    private final UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     *
     * login a user, check if the user exists in the database, create session for the user
     *
     * @return the user with the given id
     */

//    public UserDTO login(LoginDTO user) {
//
//        if(user == null) {
//            throw new RequiredFieldMissingException("user credentials are required");
//        }
//
//        if(user.getUsername() == null) {
//            throw new RequiredFieldMissingException("Username field is required");
//        }
//
//        if(user.getPassword() == null) {
//            throw new RequiredFieldMissingException("Password field is required");
//        }
//
//        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());
//
//        if (foundUser.isEmpty()) {
//            throw new ObjectNotFoundException("User not found");
//        }
//
//        if (!foundUser.get().getPassword().equals(user.getPassword())) {
//            throw new UnauthorizedException("Incorrect password");
//        }
//        return foundUser.get().toDTO();
//    }

}
