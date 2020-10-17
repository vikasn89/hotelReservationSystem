package com.spring.hotel.management.system.hotel.reservation.system.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Vikas Ramesh Kondvilkar
 *
 */
@Entity
@Table(name="room_types", uniqueConstraints = {@UniqueConstraint(name="room_type_unq_index", columnNames = {"room_type"}) })
public class RoomTypes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "ROOM_TYPE_SEQ")
	@SequenceGenerator(sequenceName = "ROOM_TYPE_SEQ", allocationSize = 1, name = "ROOM_TYPE_SEQ")
	private Long id;
	
	@Column(name="room_type", updatable = false, nullable = false)
	private String roomType;
	
	@Column(name="price_per_night", nullable = false)
	private Long pricePerNight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Long getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(Long pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	@Override
	public String toString() {
		return "RoomTypes [id=" + id + ", roomType=" + roomType + ", pricePerNight=" + pricePerNight + "]";
	}
		
}
