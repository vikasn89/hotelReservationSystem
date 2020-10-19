package com.spring.hotel.management.system.hotel.reservation.system.util;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className AuthenticationRequestModel.java
   @created 19-Oct-2020
 */
public class AuthenticationRequestModel implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotEmpty(message = "{validate.fields}")
  private String username;

  @NotEmpty(message = "{validate.fields}")
  private String password;

  private Boolean hasDeactivated;

  /**
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @param username the username to set
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the hasDeactivated
   */
  public Boolean getHasDeactivated() {
    return hasDeactivated;
  }

  /**
   * @param hasDeactivated the hasDeactivated to set
   */
  public void setHasDeactivated(Boolean hasDeactivated) {
    this.hasDeactivated = hasDeactivated;
  }

  @Override
  public String toString() {
    return "AuthenticationRequestModel [username=" + username + ", password=" + password
         + ", hasDeactivated=" + hasDeactivated + "]";
  }
}
