package tests;

import com.anat.coupons.bean.Customer;
import com.anat.coupons.controllers.CustomerController;
import com.anat.coupons.controllers.CustomerController;
import com.anat.coupons.dao.CustomerDao;
import com.anat.coupons.exceptions.ApplicationException;

public class CustomerTester {

	public static void main(String[] args) throws ApplicationException {

		CustomerController customerController = new CustomerController();
		Customer customer = null;
		
		//validate create customer:customer name is invalid
//		customer = new Customer ("m" , "maxWell11");
//		customerController.createCustomer(customer);
		
		//validate create customer: customer password is invalid
//		customer = new Customer ("maxwell" , "maxi111");
//		customerController.createCustomer(customer);
		
		//validate create customer : all OK
//		customer = new Customer ("maxwell" , "maxWell22");
//		System.out.println("id of new customer: " + customerController.createCustomer(customer));
		
		//validate delete customer: id doesnt exists
//		customerController.deleteCustomer(1);
		
		//validate delete customer + validate get customer (with a non-existing id)
//		customerController.deleteCustomer(16);
//		System.out.println(customerController.getCustomer(16));
//		
		//validate update customer : name invalid
//		customer = customerController.getCustomer(15);
//		customer.setCustomerName("a");
//		customerController.updateCustomer(customer);
		
		//validate update customer : name already exists
//		customer = customerController.getCustomer(15);
//		customer.setCustomerName("maxwell");
//		customerController.updateCustomer(customer);
		
		//validate update customer : password
//		customer = customerController.getCustomer(15);
//		customer.setCustomerPassword("1234a");
//		customerController.updateCustomer(customer);
		
		//validate update customer : all ok
//		customer = customerController.getCustomer(15);
//		System.out.println("b4 update: " + customer.toString());
//		customer.setCustomerName("zelda fruma");
//		customer.setCustomerPassword("newPass15");
//		customerController.updateCustomer(customer);
//		System.out.println("after update: " + customerController.getCustomer(15).toString());
			
		//validate get all customers
//		System.out.println(customerController.getAllCustomers());
		
		//validate login checker: invalid login
//		customer = customerController.getCustomer(15);
//		String newPassword = (customer.getCustomerPassword() + "a");
//		System.out.println(customerController.login(customer.getCustomerName(), newPassword));
		
		//validate login checker: valid login
//		customer = customerController.getCustomer(15);
//		System.out.println(customerController.login(customer.getCustomerName(), customer.getCustomerPassword()));
		
		
	}	
}
