package com.tech.service;

import com.tech.model.UserDTO;

public interface IUserService {

	String addUser(UserDTO productDTO);

	UserDTO findByUserByMobile(Integer id);
}
