package com.commons.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.commons.entity.Client;
import com.commons.entity.Role;
import com.commons.entity.User;
import com.commons.repository.UserDao;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;
	
	@Autowired
	BCryptPasswordEncoder bcry;
	
	@Override
	public User findByUserName(String userName) throws Exception {
		return userDao.findByUserName(userName);
	}

	@Override
	public void save(User user) throws Exception {
		user.setPassword(bcry.encode(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public List<Role> fetchrole(String role) throws Exception {
		// TODO Auto-generated method stub
		return userDao.findallrole(role);
		
	}

	@Override
	public List<Client> clientlist(Long id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.clientlist(id);
	}

	@Override
	public void saveclient(Client client) throws Exception {
		// TODO Auto-generated method stub
		Date created_date=new Date();
		client.setCreatedDate(created_date);
		userDao.saveclient(client);
	}

	@Override
	public List<User> adminlist(Long id,int pagenumber,int totalrecperpage) {
		// TODO Auto-generated method stub
		return userDao.adminlist(id,pagenumber,totalrecperpage);
	}

	@Override
	public int totallist(Long id) {
		// TODO Auto-generated method stub
		return userDao.totallist(id);
		
	}
}
