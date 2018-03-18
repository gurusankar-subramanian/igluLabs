package com.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.repository.*;
import com.jwt.domain.*;

/**
 * Serivice for user entity
 * @author Guru Sankar
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		return userRepository.saveAndFlush(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public User find(Long id) {
		return userRepository.findOne(id);
	}
}
