package com.spring.hotel.management.system.hotel.reservation.system.Exceptions;

/**
 * 
 * 
 * <p>
 * 
 * Created on 11-Mar-2020 at 1:31:39 pm Package Name org.unicef.mis.configuration Project Name
 * UNICEF
 * 
 * @author Aparna Satpute
 * 
 */

public class DuplicateRequestCustomException extends RuntimeException {
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
  public DuplicateRequestCustomException(String message) {
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
