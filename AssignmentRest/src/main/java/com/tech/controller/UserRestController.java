package com.tech.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.UserDTO;
import com.tech.service.IUserService;
import com.tech.utils.CONSTANTS;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserRestController {

	@Autowired
	IUserService service;

	@ApiOperation("Add new user details to database")
	@PostMapping(value = "/user/add", consumes = "application/json")
	public ResponseEntity<UserDTO> addProduct(@Valid @RequestBody UserDTO userDTO) {

		String data = service.addUser(userDTO);

		if (null != data  && data.equals(CONSTANTS.MOBILENOEXISTS)) {
			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.IM_USED);
		}

		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}
}
