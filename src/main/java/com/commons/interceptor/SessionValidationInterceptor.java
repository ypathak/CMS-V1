package com.commons.interceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SessionValidationInterceptor extends HandlerInterceptorAdapter
{
    @SuppressWarnings("unused")
	private static final String[] IGNORE_URI = {"loginAuth"};

    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setDateHeader("Expires", 0); // Proxies.
        //response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Origin", "SAMEORIGIN");
        return true;
    }
}
