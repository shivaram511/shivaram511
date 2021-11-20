package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	boolean findByUserByMobileNo(Integer mobileNo);

	void deleteByMobileNo(Integer mobileNo);

}
