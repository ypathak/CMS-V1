package com.commons.service;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.commons.utils.ApplicationConstants;

@Service
@Transactional
public class SuccessHandlerApp implements AuthenticationSuccessHandler,ApplicationConstants{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		Set<String> roles=AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		if(roles.contains(EMPLOYEE)){
			response.sendRedirect("e/");
		}else if(roles.contains(ADMIN)){
			response.sendRedirect("a/");
		}else if(roles.contains(SUPER_ADMIN)){
			response.sendRedirect("s/");
		}
	}
}
