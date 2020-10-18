/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hotel.management.system.hotel.reservation.system.services.ReservationService;
import com.spring.hotel.management.system.hotel.reservation.system.util.ConstantsUtil;
import com.spring.hotel.management.system.hotel.reservation.system.util.RuleEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className reservationController.java
   @created 16-Oct-2020
 */
@RestController
@RequestMapping("/hotel")
public class ReservationRestController 
{
	  private static final Logger logger = LoggerFactory.getLogger(ReservationRestController.class);
	  
	  @Autowired
	  ReservationService reservationService;
	  
	  /**
		 * @Param
		   @return
		 */
	  @PostMapping(value="/checkRoomAvailability")
	  public ResponseEntity<?> checkRoomAvailability(@RequestBody Map<String, String> body) throws Exception
	  {
		  
		  return reservationService.checkRoomAvailability(body) ;
	  }


	

}
