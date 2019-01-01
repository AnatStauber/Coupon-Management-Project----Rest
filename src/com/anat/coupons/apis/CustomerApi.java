package com.anat.coupons.apis;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.anat.coupons.bean.Customer;
import com.anat.coupons.controllers.CustomerController;
import com.anat.coupons.exceptions.ApplicationException;

	
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/customers")
	public class CustomerApi {

		private CustomerController customerController;
		
		public CustomerApi() {
			this.customerController = new CustomerController();
		}

		
		 @POST
		 @Path ("/createNewCustomer")
		 public void createCustomer (Customer customer) throws ApplicationException {
			long id = this.customerController.createCustomer(customer);	
			System.out.println("customer #"+ id+ " created");
			//http://localhost:8080/CouponProjectApisV2/rest/customers/createNewCustomer
		 }
		 
		 @GET
		 @Path ("/{customerId}")
		 public Customer getCustomer(@PathParam("customerId") long customerId) throws ApplicationException{
			 return (customerController.getCustomer(customerId));
			 //http://localhost:8080/CouponProjectApisV2/rest/customers/5/byId
		 }
		 
		 
		 @PUT
		 @Path ("/update")
		 public void updateCustomer  (Customer customer)  throws ApplicationException {
			 this.customerController.updateCustomer(customer);
			 long id = customer.getCustomerId();
			 System.out.println("the customer with id : " + id + " has updated");
			 //http://localhost:8080/CouponProjectApisV2/rest/customers/update
		 } 
		 
			 
		 @DELETE
		 @Path("/{customerId}")
		 public void deleteCustomer (@PathParam("customerId") long customerId) throws ApplicationException {
			 this.customerController.deleteCustomer(customerId);
//			 if (customerController.getCustomer(customerId)==null) {
//				 System.out.println("customer with cutomerId: " + customerId+ " was deleted succesfully!");
			 
			 //http://localhost:8080/CouponProjectApisV2/rest/customers/8
		 }
		 
		 
		 @GET
		 public List<Customer> getAllCustomers () throws ApplicationException {
			 return this.customerController.getAllCustomers();
			 //http://localhost:8080/CouponProjectApisV2/rest/customers/
		 }
		 
		 
		 
		 
		 
	 }


	

	
	
	
	
	


