package com.anat.coupons.apis;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anat.coupons.bean.UserLoginDetails;
import com.anat.coupons.controllers.CompanyController;
import com.anat.coupons.controllers.CustomerController;
import com.anat.coupons.exceptions.ApplicationException;
import com.anat.coupons.utils.CookieUtils;

@Path("/Login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class LoginApi {


	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	public Response login(@Context HttpServletRequest request, @Context HttpServletResponse response, UserLoginDetails userLoginDetails) throws ApplicationException {
		
		String userType = userLoginDetails.getUserType();
		String userName = userLoginDetails.getUserName();
		String password = userLoginDetails.getPassword();
		
		
		//if the user is a company 
		if(userType.equals("Company")){
			
			CompanyController companyController = new CompanyController();
			
			Long companyId = companyController.login(userName, password);//getting the company that just loggged in
			System.out.println(companyId);
		
			if (!companyId.equals(null)){
				request.getSession();
				request.getSession().setMaxInactiveInterval(30*60);
//				HttpSession session = request.getSession(); // if the credentials are correct, get a session.
				
				Cookie userTypeCookie = new Cookie("userType", userType);
				response.addCookie(userTypeCookie);
				
				String userId =String.valueOf(companyId);
				Cookie idCookie = new Cookie("userId",userId);
				response.addCookie(idCookie);	
				
				Cookie loginCookie = new Cookie("loginStatus","success");
				
				//added these settings after a horrible disgusting bug that sonehow autoatically set the login cookie as 'httpOnly' and because of that the session was never forwarded to the next request.
				//couldnt find that setting in the tomcat context.xml, so changed it only here for the n=meantime.
				loginCookie.setHttpOnly(false);
				loginCookie.setSecure(false);
				response.addCookie(loginCookie);
				
				CookieUtils.printCookies(request, response);
//				request.getRequestDispatcher("http://localhost:8080/COUPONS_PROJECT_API's/companyEntrance.html").forward(request, response);
				return Response.status(200).entity(companyId).build();
			}
			else {
				return Response.status(401).entity(null).build(); 
			}
		}
		else if (userType.equals("Customer")){
			
			CustomerController customerController = new CustomerController();
			
			Long customerId = customerController.login(userName, password);
			System.out.println(customerId);
			
			if (!customerId.equals(null)){
				
				HttpSession session =request.getSession(); // if the credentials are correct, get a session.
				session.setMaxInactiveInterval(60*30);
				
				Cookie userTypeCookie = new Cookie("userType", userType);
				response.addCookie(userTypeCookie);
				
				String userId =String.valueOf(customerId);
				Cookie idCookie = new Cookie("userId",userId);
				response.addCookie(idCookie);	
				
				Cookie loginCookie = new Cookie("loginStatus","success");
				//added these settings after a horrible disgusting bug that sonehow autoatically set the login cookie as 'httpOnly' and because of that the session was never forwarded to the next request.
				//couldnt find that setting in the tomcat context.xml, so changed it only here for the n=meantime.

				response.addCookie(loginCookie);
				

				//request.getRequestDispatcher("http://localhost:8080/COUPONS_PROJECT_API's/customerEntrance.html").forward(request, response);
				return Response.status(200).entity(customerId).build();
			}

				return Response.status(401).entity(null).build();
			}
		return Response.status(401).entity(null).build();
		
	}
}
	

	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
