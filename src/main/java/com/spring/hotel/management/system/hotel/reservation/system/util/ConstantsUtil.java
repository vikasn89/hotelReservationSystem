/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.util;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className ConstantUtil.java
   @created 18-Oct-2020
 */
public final class ConstantsUtil 
{
	 // Validation
	  public static final String RULE = "rule";
	  public static final String FIELD_NAME = "fieldName";
	  public static final String FIELD_VALUE = "fieldValue";
	  public static final String DB_VALUE = "dbValue";
	  public static final String VALIDATION = "validation";
	  public static final String API_MESSAGE = "message";
	  
	// Response message
	  public static final String BAD_REQUEST = "Can't process request, please try again!";
	  public static final String DATA_GET_SUCCESS = "Data get request successfully processed!";
	  public static final String SERVER_ERROR = "Oops, Something went wrong!";
	  public static final String DO_NOT_HAVE_PERMISSTION_TO_PERFORM_OPERATION =
	      "Sorry, you don't have permission to do this operation!";
	  public static final String INVALID_USER = "Please enter Username or Password";
	  public static final String INVALID_USERNAME = "Username does not exist";
	  public static final String INVALID_USERPASSWORD =
	      "Please verify entered password. Upon three failed attempts, your account will be inaccessible";
	  public static final String DEACTIVED_ACCOUNT =
	      "User has been deactivated, please contact your administration";
	  public static final String SERVER_EXCEPTION = "Something went wrong";
	  public static final String SUCCESS_MESSAGE = "Success";
	  public static final String SUCCESS_MESSAGE_TRUE = "TRUE";
	  public static final String SUCCESS_MESSAGE_FALSE = "FALSE";
	  public static final String INVALID_TOKEN_MESSAGE =
	      " Either user have deactivated or unable to validate the session. Please contact Administrator";
	  public static final String ERROR_MESSAGE = "Error";
	  public static final String DATA_NOT_FOUND = "Data not available";
	  public static final Boolean IS_USED_TRUE = true;
	  public static final String IS_USED = "isUsed";
	  public static final Boolean IS_USED_FALSE = false;
	  
	// Status codes
	  public static final Integer STATUS_CODE_SUCCESS = 200;
	  public static final Integer STATUS_CODE_UNPROCESSABLE_ENTITY = 422;
	  public static final Integer STATUS_CODE_SERVER_ERROR = 500;
	  public static final Integer STATUS_CODE_DATA_UNCHANGED = 601;
	  public static final Integer STATUS_CODE_INACTIVE = 603;
	  public static final Integer STATUS_CODE_DATA_NOT_AVAILABLE = 604;
	  public static final Integer STATUS_CODE_BAD_REQUEST = 400;
	  public static final Integer STATUS_CODE_UNAUTHORIZED = 401;
	  public static final Integer STATUS_CODE_NOT_FOUND = 404;
	  public static final Integer STATUS_CODE_TIME_OUT = 408;
	  public static final Integer STATUS_CODE_PASSWORD_CHANGED = 605;
	  public static final Integer STATUS_CODE_CONFLICT = 409;
	  
	  // Fields  
	  public static final String USER_NAME = "username";
	  public static final String PASSWORD= "password";
	  public static final String CNF_PASSWORD = "confirm_password";
	  public static final String ROOM_TYPE ="roomType";
	  public static final String CHECK_IN_DATE = "checkInDt";
	  public static final String CHECK_OUT_DATE = "checkOutDt";
	  
	  
	  
}
