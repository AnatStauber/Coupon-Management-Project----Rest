package tests;

import com.anat.coupons.bean.Company;
import com.anat.coupons.controllers.CompanyController;
import com.anat.coupons.dao.CompanyDao;
import com.anat.coupons.exceptions.ApplicationException;

public class CompanyTester {

	public static void main(String[] args) throws ApplicationException {

		CompanyController companyController = new CompanyController();
		Company company = null;

		//validate create company:company name
//		company = new Company ("x" , "Xiaomi111", "info@xiaomi.cn");
//		companyController.createCompany(company);
		
		//validate create company: company email
//		company = new Company ("xiaomi" , "Xiaomi111", "info.xiaomi.cn");
//		companyController.createCompany(company);
		
		//validate create  company: company password
//		company = new Company ("xiaomi" , "xiaomi", "info@xiaomi.cn");
//		companyController.createCompany(company);
		
		//validate create company : all OK
//		company = new Company ("xiaomi" , "Xiaomi111", "info@xiaomi.cn");
//		System.out.println("id of new company: " + companyController.createCompany(company));
		
		//validate delete company: id doesnt exists
//		companyController.deleteCompany(33);
		
		//validate delete company + validate get company (with a non-existing id)
//		companyController.deleteCompany(32);
//		System.out.println(companyController.getCompany(32));
//		
		//validate update company : name invalid
//		company = companyController.getCompany(17);
//		company.setCompanyName("a");
//		companyController.updateCompany(company);
		
		//validate update company : name already exists
//		company = companyController.getCompany(17);
//		company.setCompanyName("Coca-Cola");
//		companyController.updateCompany(company);
		
		//validate update company: email
//		company = companyController.getCompany(17);
//		company.setCompanyEmail("a.a.il@");
//		companyController.updateCompany(company);
		
		//validate update company : password
//		company = companyController.getCompany(17);
//		company.setCompanyPassword("1234a");
//		companyController.updateCompany(company);
		
		//validate update company : all ok
//		company = companyController.getCompany(17);
//		System.out.println("b4 update: " + company.toString());
//		company.setCompanyName("XiaomiNew");
//		company.setCompanyEmail("coupons@xiaomi.cn");
//		company.setCompanyPassword("newPass12");
//		companyController.updateCompany(company);
//		System.out.println("after update: " + companyController.getCompany(17).toString());
			
		//validate get all companies
//		System.out.println(companyController.getAllCompanies());
		
		//validate login checker: invalid login
//		company = companyController.getCompany(6);
//		String newPassword = (company.getCompanyPassword() + "a");
//		System.out.println(companyController.login(company.getCompanyName(), newPassword));
		
		//validate login checker: valid login
//		company = companyController.getCompany(6);
//		System.out.println(companyController.login(company.getCompanyName(), company.getCompanyPassword()));
		
		
	}

}
