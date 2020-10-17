/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.*;

/**
 * @author Vikas Ramesh Kondvilkar
 * @class name Registration.java
   @created 16-Oct-2020
 */

@Entity
@Table(name="reservation", uniqueConstraints ={@UniqueConstraint(name="reservation_no_unq_index", columnNames = {"reservation_no"})
,@UniqueConstraint(name="customer_email_unq_index", columnNames = {"email_id"} )})
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "RESERVATION_SEQ")
	@SequenceGenerator(sequenceName = "RESERVATION_SEQ", allocationSize = 1, name = "RESERVATION_SEQ")
	private Long id;
	
	@Column(name="reservation_no", updatable = false, nullable = false)
	private String reservationNo;
	
	
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "reservation_customers",
            joinColumns = @JoinColumn(name = "reservation_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cust_id", referencedColumnName = "id")
    )
    private Set<Customer> guests = new HashSet<>();
	
    @OneToOne(mappedBy = "registration") 
	private Room room;
	
    @Column(name="no_of_guests",  nullable = false)
	private Integer noOfGuests;
	
    @Column(name="check_in_dt", nullable = false)
    @Temporal(TemporalType.DATE)
	private LocalDate checkInDt;
	
    @Column(name="check_out_dt")
    @Temporal(TemporalType.DATE)
	private LocalDate checkOutDt;

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
