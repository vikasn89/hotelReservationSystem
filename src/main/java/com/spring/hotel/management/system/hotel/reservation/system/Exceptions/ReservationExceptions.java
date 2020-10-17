/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.Exceptions;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className ReservationExceptions.java
   @created 17-Oct-2020
 */
public class ReservationExceptions extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param message
	 */
	public ReservationExceptions(String message) {
		super();
		this.message = message;
	}
	
	public String printMessages(String message)
	{
		return message;
	}
	
	public String printMessages(String message, Exception ex)
	{
		return message;
	}
	

}
