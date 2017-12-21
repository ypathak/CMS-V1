package com.commons.repository;

import java.util.List;

import com.commons.entity.Role;
import com.commons.entity.User;

public interface UserDao{
	User findByUserName(String userName) throws Exception;
	List<Role> findallrole(String role) throws Exception;
	void save(User user) throws Exception;
}
