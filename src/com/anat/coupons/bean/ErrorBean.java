package com.anat.coupons.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorBean {

	private int errorCode;
	private String internalMessage;
	private String errorMessage;

	public ErrorBean() {
		super();
	}

	public ErrorBean(int errorCode, String internalMessage, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.internalMessage = internalMessage;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getInternalMessage() {
		return internalMessage;
	}

	public void setInternalMessage(String internalMessage) {
		this.internalMessage = internalMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ErrorBean [errorCode=" + errorCode + ", internalMessage=" + internalMessage + ", errorMessage="
				+ errorMessage + "]";
	}

}
