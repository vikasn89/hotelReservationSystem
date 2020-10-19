package com.spring.hotel.management.system.hotel.reservation.system.Exceptions;


/**
 * @author Vikas Ramesh Kondvilkar
 * @className CustomException.java
   @created 19-Oct-2020
 */
public class CustomException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String message;

  /**
   * Parameterized constructor
   * 
   * @param message
   */
  public CustomException(String message) {
    super();
    this.message = message;
  }


  /**
   * return message
   */
  @Override
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }
}
