package com.anat.coupons.servlets;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.websocket.Session;
import com.anat.coupons.utils.CookieUtils;
import com.sun.jersey.core.reflection.AnnotatedMethod;
import com.sun.jersey.core.reflection.MethodList.Filter;

public class LoginFilter implements javax.servlet.Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		// origin of request:
		String pageRequested = httpRequest.getRequestURI().toString();
		
		// getting the user's session - only if one exists
		HttpSession session = httpRequest.getSession(false);

		//if session exists (or the page requested ends with "/login" or "/register",
		// then we return the reference of that session object
		if (session != null || pageRequested.endsWith("/Login") || pageRequested.endsWith("/register")){
			//adding the cookies from the request to response
			CookieUtils.setResponseCookies(httpRequest, httpResponse);
			chain.doFilter(httpRequest, httpResponse);
			return;
		}
		
		
		// if a session does not exist - meaning the user havent logged in yet, then we
		// set the response to error (401)	
		httpResponse.setStatus(401);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	

	@Override
	public void destroy() {
	}

}