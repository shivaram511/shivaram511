package com.tech.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tech.entity.User;
import com.tech.model.UserDTO;
import com.tech.repository.UserRepository;
import com.tech.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository userRepository;

	@Cacheable(value = "AllUsersCache", key = "#root.methodName")

	@Override
	public String addUser(UserDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		if (userRepository.findByUserByMobileNo(user.getMobileNo())) {
			userRepository.deleteByMobileNo(userDTO.getMobileNo());
			userRepository.save(user);
			return "Mobile Number already exist";
		} else {
			userRepository.save(user);
			return "User is added to Database";
		}
	}

}
