package com.commons.service;

import java.util.List;

import com.commons.entity.Client;
import com.commons.entity.Role;
import com.commons.entity.User;

public interface UserService {

	User findByUserName(String userName) throws Exception;
	
	void save(User user) throws Exception;

	List<Role> fetchrole(String role) throws Exception;

	List<Client> clientlist(Long id) throws Exception;

	void saveclient(Client client) throws Exception;

	List<User> adminlist(Long id, int pagenumber);

	int totallist(Long id);

}
