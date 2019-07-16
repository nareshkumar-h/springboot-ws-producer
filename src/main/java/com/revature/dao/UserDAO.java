package com.revature.dao;

import com.revature.webservice.User;

public class UserDAO {

	public static User login(String email, String password) {
		
		User dto = new User();
		dto.setId(1);
		dto.setName("naresh");
		dto.setEmail("naresh@gmail.com");
		dto.setPassword("pass123");
		
		return dto;
		//throw new RuntimeException("Invalid Login");
		
		
	}
}
