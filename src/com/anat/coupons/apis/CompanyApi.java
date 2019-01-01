package com.anat.coupons.apis;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anat.coupons.bean.Company;
import com.anat.coupons.bean.UserLoginDetails;
import com.anat.coupons.controllers.CompanyController;
import com.anat.coupons.exceptions.ApplicationException;
import com.anat.coupons.utils.CookieUtils;



@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/companies")
public class CompanyApi {
	
	private CompanyController companyController;

	public CompanyApi() {
		this.companyController = new CompanyController();
	}
	
	 @POST
	 @Path ("/createNewCompany")
	 public void createCompany (Company company) throws ApplicationException {
		long id = this.companyController.createCompany(company);	
		System.out.println("company #"+ id+ " created");
		//http://localhost:8080/CouponProjectApisV2/rest/companies/createNewCompany
	 }

	 
	 @PUT
	 @Path ("/update")
	 public void updateCompany (Company company)  throws ApplicationException {
		 this.companyController.updateCompany(company);
		 long id = company.getCompanyId();
		 System.out.println("the company with id : " + id + " has updated");
		 //http://localhost:8080/CouponProjectApisV2/rest/companies/update
	 } 
	 
		 
	 @DELETE
	 @Path ("/{companyId}")
	 public void deleteCompany (@PathParam ("companyId") long companyId) throws ApplicationException {
		
		 this.companyController.deleteCompany(companyId);
		 
		 //http://localhost:8080/CouponProjectApisV2/rest/companies
	 }
	
	 @GET
	 @Path ("/{companyId}")
	 public Company getCompany(@PathParam("companyId") long companyId) throws ApplicationException{
		
		 return (companyController.getCompany(companyId));
		 //http://localhost:8080/CouponProjectApisV2/rest/companies/17/
	 }

	@GET
	public List<Company> getAllCompanies () throws ApplicationException {
		 return this.companyController.getAllCompanies();
//		 http://localhost:8080/CouponProjectApisV2/rest/companies
	}
	
	
}
