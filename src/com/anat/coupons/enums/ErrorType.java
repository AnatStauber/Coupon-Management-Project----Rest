package com.anat.coupons.enums;

public enum ErrorType{
	
	GENERAL_ERROR(800), 
	INVALID_LOGIN(801), 
	INVALID_PARAMETER(802), 
	MISSING_PARAMETERS(803), 
	NULL_VALUE(804),
	DATABASE_ERROR(805), 
	SESSION_TIMEOUT(806), 
	SYSTEM_ERROR(605), 
	ACTION_CANNOT_BE_COMPLETED(606), 
	EMPTY_LIST(607);

	private int errorCode;

	private ErrorType(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return this.name();
	}

	public static ErrorType fromString (final String s) {
		return ErrorType.valueOf(s);
	}
}