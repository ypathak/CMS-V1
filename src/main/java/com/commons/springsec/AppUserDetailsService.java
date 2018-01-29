package com.commons.springsec;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.commons.entity.Role;
import com.commons.entity.User;
import com.commons.service.UserService;

@Component
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    public AppUserDetail loadUserByUsername(String name) throws UsernameNotFoundException, DataAccessException {
        // returns the get(0) of the user list obtained from the db
        User domainUser = null;
		try {
			domainUser = userService.findByUserName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UsernameNotFoundException("Invalid User");
		}

        Set<Role> roles = domainUser.getRoles();

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        
        for(Role role: roles){
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
            System.out.println("role" + role + " role.getRole()" + (role.getRole()));
        }

        AppUserDetail appUserDetail=new AppUserDetail();
        appUserDetail.setUser(domainUser);
        appUserDetail.setAuthorities(authorities);

        return appUserDetail;

    }

}