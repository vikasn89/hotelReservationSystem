/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.spring.hotel.management.system.hotel.reservation.system.entity.Customer;
import com.spring.hotel.management.system.hotel.reservation.system.entity.Room;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className ReservationModel.java
   @created 17-Oct-2020
 */
public class ReservationModel 
{
private Set<Customer> guests = new HashSet<>();
	
	private Room room;
	
	private Integer noOfGuests;
	
	private LocalDate checkInDt;
	
	private LocalDate checkOutDt;

	public Set<Customer> getGuests() {
		return guests;
	}

	public void setGuests(Set<Customer> guests) {
		this.guests = guests;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Integer getNoOfGuests() {
		return noOfGuests;
	}

	public void setNoOfGuests(Integer noOfGuests) {
		this.noOfGuests = noOfGuests;
	}

	public LocalDate getCheckInDt() {
		return checkInDt;
	}

	public void setCheckInDt(LocalDate checkInDt) {
		this.checkInDt = checkInDt;
	}

	public LocalDate getCheckOutDt() {
		return checkOutDt;
	}

	public void setCheckOutDt(LocalDate checkOutDt) {
		this.checkOutDt = checkOutDt;
	}
}
