package com.eic.springboot.service;

import java.util.List;

import com.eic.springboot.dto.UserDto;
import com.eic.springboot.entity.User;


public interface UserService {
	UserDto createUser(UserDto userDto);
	
	UserDto findUserById(Long userId);
	
	List<UserDto> getAllUsers();
	
	UserDto updateUser(Long userId, UserDto user);
	
	void deleteUser(Long userId);


}
