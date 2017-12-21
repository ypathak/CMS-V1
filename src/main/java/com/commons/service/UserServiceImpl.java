package com.commons.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.commons.entity.Role;
import com.commons.entity.User;
import com.commons.repository.UserDao;
import com.commons.repository.UserDaoImpl;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;
	
	@Autowired
	BCryptPasswordEncoder bcry;
	
	@Override
	public void findByUserName(String userName) throws Exception {
		userDao.findByUserName(userName);
	}

	@Override
	public void save(User user) throws Exception {
		user.setPassword(bcry.encode(user.getPassword()));
		Date created_date=new Date();
		user.setCreatedDate(created_date);
		userDao.save(user);
	}

	@Override
	public List<Role> fetchrole(String role) throws Exception {
		// TODO Auto-generated method stub
		return userDao.findallrole(role);
		
	}
}
