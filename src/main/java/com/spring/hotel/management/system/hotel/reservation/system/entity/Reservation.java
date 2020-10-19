/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author Vikas Ramesh Kondvilkar
 * @class name Registration.java
   @created 16-Oct-2020
 */

@Entity
@Table(name="reservations", uniqueConstraints ={@UniqueConstraint(name="reservation_no_unq_index", columnNames = {"reservation_no"})
})
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "RESERVATION_SEQ")
	@SequenceGenerator(sequenceName = "RESERVATION_SEQ", allocationSize = 1, name = "RESERVATION_SEQ")
	private Long id;
	
	@Column(name="reservation_no", updatable = false, nullable = false)
	private String reservationNo;
	
	@OneToOne(fetch = FetchType.EAGER ) 
	@JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
	
    @OneToOne(fetch = FetchType.EAGER ) 
	@JoinColumn(name = "room_id", nullable = false)
	private Room room;
	
    @Column(name="no_of_guests",  nullable = false)
	private Integer noOfGuests;
	
    @Column(name="check_in_dt", nullable = false)
	private LocalDate checkInDt;
	
    @Column(name="check_out_dt")
	private LocalDate checkOutDt;

    @Column(name="reservation_amount")
    private Long reservationAmount;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(String reservationNo) {
		this.reservationNo = reservationNo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public Long getReservationAmount() {
		return reservationAmount;
	}

	public void setReservationAmount(Long reservationAmount) {
		this.reservationAmount = reservationAmount;
	}
    
}
