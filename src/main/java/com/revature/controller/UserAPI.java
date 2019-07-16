package com.revature.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.revature.dao.UserDAO;
import com.revature.webservice.GetLoginRequest;
import com.revature.webservice.GetLoginResponse;
import com.revature.webservice.User;

@Endpoint
public class UserAPI {

	private static final String NAMESPACE_URI = "http://revature.com/webservice";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLoginRequest")
	@ResponsePayload
	public GetLoginResponse login(@RequestPayload GetLoginRequest request) {
		System.out.println("Received Request");
		System.out.println("Email:" + request.getEmail());
		System.out.println("Password:" + request.getPassword());
		User user = UserDAO.login(request.getEmail(), request.getPassword());
		GetLoginResponse response = new GetLoginResponse();
		response.setUser(user);
		System.out.println("Returning Response"  + user);		
		return response;
	}
	
}
