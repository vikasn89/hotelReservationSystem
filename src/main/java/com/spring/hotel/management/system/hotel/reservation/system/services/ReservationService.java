/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.hotel.management.system.hotel.reservation.system.entity.ResponseEntityModel;
import com.spring.hotel.management.system.hotel.reservation.system.repositories.IReservationRepository;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className ReservationService.java
   @created 17-Oct-2020
 */
@Service
public class ReservationService 
{
	@Autowired
	IReservationRepository reservsationRepository;
	
	@PostMapping("reservation")
	public <T> ResponseEntityModel getReservations()
	{
		
		
		return null;
	}
	
}
