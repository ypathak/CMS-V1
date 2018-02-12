package com.commons.springsec;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.commons.entity.User;

@Component
public class AppUserDetail implements UserDetails{

    private static final long serialVersionUID = 1L;
    private User user;

    Set<GrantedAuthority> authorities=null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities)
    {
        this.authorities=authorities;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public boolean isAccountNonExpired() {
    	if(user.isDeleted){
    		return false;
    	}else {
    		return true;
    	}
    }

    public boolean isAccountNonLocked() {
    	if(user.isDeleted){
    		return false;
    	}else {
    		return true;
    	}
    }

    public boolean isCredentialsNonExpired() {
    	if(user.isDeleted){
    		return false;
    	}else {
    		return true;
    	}
    }

    public boolean isEnabled() {
    	if(user.isDeleted){
    		return false;
    	}else {
    		return true;
    	}
    }

}