package com.commons.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.commons.entity.Role;
import com.commons.entity.User;
import com.commons.repository.UserDao;
@Service("UserDetailsService")
@Transactional
public class AuthenticationProviderApp  implements UserDetailsService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String uname) throws UsernameNotFoundException {
		User user = null;
		try {
			user = userDao.findByUserName(uname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UsernameNotFoundException("Invalid User");
		}
		Set<GrantedAuthority> grantedAuthorities=new HashSet<GrantedAuthority>();
		Set<Role> role = user.getRoles();	   
		for(Role role2:role){
			grantedAuthorities.add(new SimpleGrantedAuthority(role2.getRole()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
}
