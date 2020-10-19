package com.spring.hotel.management.system.hotel.reservation.system.util;

import java.io.Serializable;
import java.util.Map;


/**
 * @author Vikas Ramesh Kondvilkar
 * @className SuccessResponse.java
   @created 19-Oct-2020
 */
public class SuccessResponse implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private Integer status;

  private String message;

  private Map<String, Object> data;

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

  /**
   * @return data
   */
  public Map<String, Object> getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(Map<String, Object> data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "SuccessResponse [status=" + status + ", message=" + message + ", data=" + data + "]";
  }
}

