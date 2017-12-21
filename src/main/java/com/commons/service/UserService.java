package com.commons.service;

import java.util.List;

import com.commons.entity.Role;
import com.commons.entity.User;

public interface UserService {

	public void findByUserName(String userName) throws Exception;

	public void save(User user) throws Exception;

	public List<Role> fetchrole(String role) throws Exception;

}
