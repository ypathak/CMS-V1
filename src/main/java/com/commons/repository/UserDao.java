package com.commons.repository;

import java.util.List;

import com.commons.entity.Client;
import com.commons.entity.Role;
import com.commons.entity.User;

public interface UserDao{
	User findByUserName(String userName) throws Exception;
	List<Role> findallrole(String role) throws Exception;
	void save(User user) throws Exception;
	List<Client> clientlist(Long long1) throws Exception;
	void saveclient(Client client) throws Exception;
	List<User> adminlist(Long id, int pagenumber);
	int totallist(Long id);
}
