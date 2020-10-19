package com.spring.hotel.management.system.hotel.reservation.system.util;

import java.io.Serializable;


/**
 * @author Vikas Ramesh Kondvilkar
 * @className ErrorResponse.java
   @created 19-Oct-2020
 */
public class ErrorResponse implements Serializable {

  /**
   * 
   */

  private static final long serialVersionUID = 1L;

  private Integer status;

  private String message;

  private String messageDetails;


  public ErrorResponse() {}

  /**
   * Parameterized constructor
   * 
   * @param status
   * @param message
   */
  public ErrorResponse(Integer status, String message) {
    super();
    this.status = status;
    this.message = message;
  }

  /**
   * Parameterized constructor
   * 
   * @param status
   * @param message
   */
  public ErrorResponse(Integer status, String message, String messageDetails) {
    super();
    this.status = status;
    this.message = message;
    this.messageDetails = messageDetails;

  }

  /**
   * @return status
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * @return message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  public String getMessageDetails() {
    return messageDetails;
  }

  public void setMessageDetails(String messageDetails) {
    this.messageDetails = messageDetails;
  }
}

