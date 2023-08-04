package com.eic.springboot.service;

import com.eic.springboot.dto.LoginDto;
import com.eic.springboot.dto.UserDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(UserDto userDto);
}
