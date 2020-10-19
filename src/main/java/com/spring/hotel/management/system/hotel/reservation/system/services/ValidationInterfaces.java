package com.spring.hotel.management.system.hotel.reservation.system.services;


import java.util.HashMap;
import java.util.List;
import org.springframework.context.NoSuchMessageException;

import com.spring.hotel.management.system.hotel.reservation.system.Exceptions.CustomException;


/**
 * @author Vikas Ramesh Kondvilkar
 * @className ValidationInterfaces.java
   @created 19-Oct-2020
 */

public class ValidationInterfaces {
  public interface didValidate {
    void didValidate(boolean isSuccess, List<HashMap<String, Enum>> errorMessage)
        throws NoSuchMessageException, CustomException;
  }
}
