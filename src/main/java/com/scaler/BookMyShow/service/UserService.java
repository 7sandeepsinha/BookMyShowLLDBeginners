package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.models.User;

public interface UserService {
     User login(String email, String password);
     User signUp(String name, String email, String password);
}
