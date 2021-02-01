package com.smart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.dao.UserDao;
import com.smart.entities.User;

public class UserDetailsServiceImp implements UserDetailsService {
	@Autowired
	private UserDao userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("could not found user");

		}
		CustomeUserDetails customeUserDetails = new CustomeUserDetails(user);
		return customeUserDetails;
	}

}
