/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.hotel.management.system.hotel.reservation.system.entity.Reservation;
import com.spring.hotel.management.system.hotel.reservation.system.model.ReservationModel;
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
	
	
	public ReservationModel addReservations(ReservationModel reservModel) throws Exception
	{
		Reservation reserv = new Reservation();
		reserv.setReservationNo(UUID.randomUUID().toString());
		
		return null;
	}
	
}
