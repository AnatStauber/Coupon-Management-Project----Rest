package tests;

import java.util.Date;

import com.anat.coupons.bean.Coupon;
import com.anat.coupons.controllers.CouponController;
import com.anat.coupons.enums.CouponType;
import com.anat.coupons.exceptions.ApplicationException;

public class CouponTester {

	public static void main(String[] args) throws ApplicationException {

//		CouponsDao couponDao = new CouponsDao();

		CouponController couponController = new CouponController();
		Coupon coupon = null;
		
		// testing the createCoupon - title validation - too long
//		coupon = new Coupon ("xiaomi a4 for only 499.99 ILSjndcjdkjfd.bv.jfzbkvbfvzjvb.kjzbvuzbvjbfzkuvbufvbkzjfvbjkzbkuvfbkvkjz!", "2018-10-27", "2018-10-30", 20, "amzing phone, amazing price!", 399.99, "abc", CouponType.ELECTRICITY, 14);
//		couponController.createCoupon(coupon);

		// testing the createCoupon - title validation - too short
//		coupon = new Coupon ("x", "2018-10-27", "2018-10-30", 20, "amzing phone, amazing price!", 399.99, "abc", CouponType.ELECTRICITY, 14);
//		couponController.createCoupon(coupon);

		// testing the createCoupon - title validation - already exist for company
//		coupon = new Coupon ("xiaomi a4 for only 499.99 ILS!", "2018-10-27", "2018-10-30", 20, "amzing phone, amazing price!", 399.99, "abc", CouponType.ELECTRICITY, 14);
//		couponController.createCoupon(coupon);
//		couponController.createCoupon(coupon);

		// testing the createCoupon - dates validation - format
//		coupon = new Coupon ("xiaomi a300 for only 499.99 ILS!", "2018/10/27", "2018-10-30", 20, "amzing phone, amazing price!", 399.99, "abc", CouponType.ELECTRICITY, 14);
//		couponController.createCoupon(coupon);

		// testing the createCoupon - dates validation - end date has passed
//		coupon = new Coupon ("xiaomi a300 for only 499.99 ILS!", "2018-10-27", "2018-10-28", 20, "amzing phone, amazing price!", 399.99, "abc", CouponType.ELECTRICITY, 14);
//		couponController.createCoupon(coupon);		

		// testing the createCoupon - dates validation - end date before startDate
//		coupon = new Coupon ("xiaomi a300 for only 499.99 ILS!", "2018-10-31", "2018-10-30", 20, "amzing phone, amazing price!", 399.99, "abc", CouponType.ELECTRICITY, 14);
//		couponController.createCoupon(coupon);	

		// testing the createCoupon - dates validation - date doesnt exist (example:
		// november 31)
//		coupon = new Coupon ("xiaomi a330 for only 499.99 ILS!", "2018-10-31", "2018-11-31", 20, "amzing phone, amazing price!", 399.99, "abc", CouponType.ELECTRICITY, 14);
//		couponController.createCoupon(coupon);	

		// testing the createCoupon - amount validation
//		coupon = new Coupon ("xiaomi a360 for only 499.99 ILS!", "2018-10-01", "2018-10-30", -1, "amzing phone, amazing price!", 399.99, "abc", CouponType.ELECTRICITY, 14);
//		couponController.createCoupon(coupon);	

		// testing the createCoupon - message validation
//		coupon = new Coupon ("xiaomi a360 for only 499.99 ILS!", "2018-10-01", "2018-10-30", 10, "a", 399.99, "abc", CouponType.ELECTRICITY, 14);
//		couponController.createCoupon(coupon);

		// testing the createCoupon - price validation
//		coupon = new Coupon ("xiaomi a360 for only 499.99 ILS!", "2018-10-01", "2018-10-30", 10, "abcdefg", 0, "abc", CouponType.ELECTRICITY, 14);
//		couponController.createCoupon(coupon);

		// testing the createCoupon - companyId validation
//		coupon = new Coupon ("xiaomi a360 for only 499.99 ILS!", "2018-10-01", "2018-10-30", 10, "abcdefg", 390, "abc", CouponType.ELECTRICITY, 1000);//id that doesnt exist
//		couponController.createCoupon(coupon);

		// testing the createCoupon - return value is correct
//		coupon = new Coupon ("xiaomi a360 for only 499.99 ILS!", "2018-10-01", "2018-10-30", 10, "abcdefg", 390, "abc", CouponType.ELECTRICITY, 14);
//		System.out.println(couponController.createCoupon(coupon));

		// testing purchase coupon: couponId doesnt exist
//		couponController.purchaseCoupon(6, 1, 10);

		// testing purchase coupon: customerId doesnt exist
//		couponController.purchaseCoupon(1, 74, 10);

		// testing update method : changing the amount
//		coupon = couponController.getCoupon(74);
//		coupon.setCouponAmount(1);
//		couponController.updateCoupon(coupon);
//		System.out.println(couponController.getCoupon(74).getCouponAmount());

		// testing purchase coupon: amount not allowed
//		couponController.purchaseCoupon(6, 74, 10);

		// testing purchase coupon: amount not valid
//		couponController.purchaseCoupon(6, 74, -10);

//		//testing purchase coupon: subtracting amount
//		System.out.println(couponController.getCoupon(46).getCouponAmount());
//		couponController.purchaseCoupon(6, 46, 101);
//		System.out.println(couponController.getCoupon(46).getCouponAmount());

		// testing the deleteCoupon + get coupon

//		coupon = couponController.getCoupon(1000);
//		coupon = couponController.getCoupon(75);
//		couponController.deleteCoupon(coupon.getCouponId());
	    	

		//testing the 'get' methods:
//		System.out.println("all active coupons of customer #13:\n" +couponController.getActiveCouponsByCustomer(13));
//		System.out.println("all coupons of customer #13:\n" +couponController.getAllCouponsByCustomer(13));
//		System.out.println("all active coupons of company #11:\n" +couponController.getActiveCouponsByCompany(11));
//		System.out.println("all coupons of company #11:\n" +couponController.getAllCouponsByCompany(11));
//		System.out.println("all active coupons:\n" +couponController.getAllActiveCoupons());
//		System.out.println("all coupons: \n" +couponController.getAllCoupons());
//		System.out.println("coupon #41: \n" +couponController.getCoupon(41));
//		System.out.println("all active coupons that expire until 5 days from now: \n" + couponController.getCouponsByEndDate(String.valueOf(new Date().getTime()+5)));
//		System.out.println("all active coupons between the prices 25-49: \n" +couponController.getCouponsByPrices(25, 49));
		
	}

}