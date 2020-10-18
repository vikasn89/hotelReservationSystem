/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className LoginController.java
   @created 16-Oct-2020
 */
@RestController
@RequestMapping(value = "/hotel")
public class LoginController {
	
	@Autowired
	  private AuthenticationManager authenticationManager;

}
