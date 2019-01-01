package com.anat.coupons.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.anat.coupons.bean.ErrorBean;

@Provider
public class ExceptionHandler implements ExceptionMapper<Throwable>{
	
	@Override
	public Response toResponse(Throwable exception) {
		
		exception.getStackTrace();
		
		//if the caught exception is an exception we've thrown-
		if (exception instanceof ApplicationException) {
			ApplicationException appException = (ApplicationException) exception;
			String errorMessage = appException.getErrorType().getErrorMessage();
			String internalMessage = appException.getMessage();
			int errorCode = appException.getErrorType().getErrorCode();
			ErrorBean errorBeans = new ErrorBean(errorCode, internalMessage, errorMessage);

			//the response, including the errorBean 
			Response response = Response.status(errorCode).entity(errorBeans).build();
			
			//only for checking:
			System.out.println("status: " +response.getStatus());
			System.out.println("entity: " +response.getEntity());
			
			return response;
			//return Response.status(errorCode).entity(errorBeans).build();
		}

		//here we handle an exception that we didn't caught and warped 
			String internalMessage = exception.getMessage();
			ErrorBean errorBeans = new ErrorBean(601, internalMessage, "General Exception");
			return Response.status(601).entity(errorBeans).build();

}
}
