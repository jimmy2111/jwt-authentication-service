package com.eic.springboot.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eic.springboot.dto.UserDto;
import com.eic.springboot.entity.User;
import com.eic.springboot.exception.EmailAlreadyExistsException;
import com.eic.springboot.exception.ResourceNotFoundException;
import com.eic.springboot.exception.UserNotRegisteredException;
import com.eic.springboot.repository.UserRepository;
import com.eic.springboot.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserRepository userRepository;
	
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
		if(optionalUser.isPresent()) {
			LOGGER.error("Email Already Exists");
			throw new EmailAlreadyExistsException("Email Already Exists for User");
		}
		LOGGER.info("Creating User");
		User user = modelMapper.map(userDto, User.class);
		user.setPassword(userDto.getPassword());
		User savedUser = userRepository.save(user);
		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
		return savedUserDto;
	}

	@Override
	public UserDto findUserById(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException("User", "id", userId)
		);
		LOGGER.info("Fetching User By Id");
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		LOGGER.info("Fetching List of users");
		return users.stream()
				.map((user)->modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(Long userId, UserDto user) {
		User existingUser = userRepository.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException("User", "id", userId));
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		User updatedUser = userRepository.save(existingUser);
		LOGGER.info("User Details Updated");
		return modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public void deleteUser(Long userId) {
		User existingUser = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );
		userRepository.deleteById(userId);
		LOGGER.info("User Deleted Successfully");
	}



}
