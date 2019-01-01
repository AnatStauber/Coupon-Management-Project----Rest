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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.anat.coupons.bean.Coupon;
import com.anat.coupons.bean.Purchase;
import com.anat.coupons.controllers.CouponController;
import com.anat.coupons.enums.CouponType;
import com.anat.coupons.exceptions.ApplicationException;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/coupons")
public class CouponApi {

	
	private CouponController couponController;
	
	public CouponApi() {
		this.couponController = new CouponController();
	}

	@POST
	@Path("/createCoupon")
	public Coupon createCoupon(Coupon coupon) throws ApplicationException {

		long id = this.couponController.createCoupon(coupon);
		System.out.println("coupon #" + id + " created");
		return this.couponController.getCoupon(id);
//		http://localhost:8080/CouponProjectApisV2/rest/coupons/createCoupon
	}

	@DELETE
	@Path("/{couponId}")
	public void deleteCoupon(@PathParam("couponId") long couponId) throws ApplicationException {
		this.couponController.deleteCoupon(couponId);
//		 http://localhost:8080/CouponProjectApisV2/rest/coupons/76
	}

	@PUT
	@Path("/update")
	public void updateCoupon(Coupon coupon) throws ApplicationException {
		this.couponController.updateCoupon(coupon);
		long id = coupon.getCouponId();
		System.out.println("coupon #" + id + " was updated");
//		 http://localhost:8080/CouponProjectApisV2/rest/coupons/update
	}

	@GET
	@Path("/{couponId}")
	public Coupon getCoupon(@PathParam("couponId") long couponId) throws ApplicationException {

		return (couponController.getCoupon(couponId));
//		 http://localhost:8080/CouponProjectApisV2/rest/coupons/40/byId
	}

	@GET
	@Path("/byType")
	public List<Coupon> getCouponsByType(@QueryParam("type") String type) throws ApplicationException {

		CouponType couponType = CouponType.valueOf(type);
		return (this.couponController.getCouponsByType(couponType));
//		 http://localhost:8080/CouponProjectApisV2/rest/coupons/FOOD/byType		 
	}

	@GET
	@Path("/b4EndDate")
	public List<Coupon> getCouponsBeforeEndDate(@QueryParam("endDate") String endDate) throws ApplicationException {

		return (this.couponController.getCouponsByEndDate(endDate));
//		 http://localhost:8080/CouponProjectApisV2/rest/coupons/b4EndDate?endDate=2019-02-01
	}

	@GET
	@Path("/byPrices")
	public List<Coupon> getCouponsByPrices(@QueryParam("minPrice") double minPrice,
			@QueryParam("maxPrice") double maxPrice) throws ApplicationException {

		return (this.couponController.getCouponsByPrices(minPrice, maxPrice));
//		 http://localhost:8080/CouponProjectApisV2/rest/coupons/byPrices?minPrice=20&maxPrice=100
	}

	@GET
	@Path("/activeCoupons")
	public List<Coupon> getAllActiveCoupons() throws ApplicationException {
		return this.couponController.getAllActiveCoupons();
	}

	@GET
	public List<Coupon> getAllCoupons() throws ApplicationException {
		return this.couponController.getAllCoupons();
//		 http://localhost:8080/CouponProjectApisV2/rest/coupons	 
	}

	@GET
	@Path("/companyActiveCoupons/{companyId}")
	public List<Coupon> getActiveCouponsByCompany(@PathParam("companyId") long companyId) throws ApplicationException {
		return this.couponController.getActiveCouponsByCompany(companyId);
//		 http://localhost:8080/CouponProjectApisV2/rest/coupons/companyActiveCoupons/14
	}

	@GET
	@Path("/company/{companyId}")
	public List<Coupon> getAllCouponsByCompany(@PathParam("companyId") long companyId) throws ApplicationException {
		return this.couponController.getAllCouponsByCompany(companyId);
//		 	http://localhost:8080/CouponProjectApisV2/rest/coupons/allCompanyCoupons/14
	}

	@GET
	@Path("customerActiveCoupons/{customerId}")
	public List<Coupon> getActiveCouponsByCustomer(@PathParam("customerId") long customerId)
			throws ApplicationException {
		return this.couponController.getActiveCouponsByCustomer(customerId);
//		 	http://localhost:8080/CouponProjectApisV2/rest/coupons/customerActiveCoupons/13
	}

	@GET
	@Path("customer/{customerId}")
	public List<Coupon> getAllCouponsByCustomer(@PathParam("customerId") long customerId) throws ApplicationException {
		return this.couponController.getAllCouponsByCustomer(customerId);
//		 http://localhost:8080/CouponProjectApisV2/rest/coupons/allCustomerCoupons/13
	}

	@POST
	@Path("/purchaseCoupon")
	public void purchaseCoupon(Purchase purchase) throws ApplicationException {
		long couponId = purchase.getCouponId();
		long customerId = purchase.getCustomerId();
		int amount = purchase.getAmount();
		this.couponController.purchaseCoupon(customerId, couponId, amount);
	}

}
