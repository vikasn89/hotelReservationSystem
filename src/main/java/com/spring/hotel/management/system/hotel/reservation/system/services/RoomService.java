/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotel.management.system.hotel.reservation.system.repositories.IRoomRerpository;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className RoomService.java
   @created 18-Oct-2020
 */
@Service
public class RoomService 
{
	 private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);
	 
	 @Autowired
	 IRoomRerpository roomRepository;
	 
	
	
}
