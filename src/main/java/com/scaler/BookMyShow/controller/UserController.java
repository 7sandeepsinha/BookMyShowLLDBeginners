package com.scaler.BookMyShow.controller;

import com.scaler.BookMyShow.dto.UserSignUpRequestDTO;
import com.scaler.BookMyShow.dto.UserSignUpResponseDTO;
import com.scaler.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService; // interface

    public UserSignUpResponseDTO signUp(UserSignUpRequestDTO userSignUpRequestDTO){

    }

}

// doubts -> 8:17 AM
// Spring in Action
