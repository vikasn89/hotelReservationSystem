/**
 * @author Vikas Ramesh Kondvilkar
 * @name Room.java
   @created 3:04:56 pm	
 */
package com.spring.hotel.management.system.hotel.reservation.system.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Vikas Ramesh Kondvilkar
 * @class Room.java
   @created 16-Oct-2020
 */

@Entity
@Table(name="room", uniqueConstraints = {@UniqueConstraint(name="room_unq_index", columnNames = {"room_no"}) })

public class Room implements Serializable
{
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "ROOM_SEQ")
	@SequenceGenerator(sequenceName = "ROOM_SEQ", allocationSize = 1, name = "ROOM_SEQ")
	private Long id;
	
	@Column(name="room_no", nullable = false)
	private String roomNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_type_id", nullable = false)
	private RoomType roomType;
	
	@Column(name="is_available")
	private Boolean available;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNo=" + roomNo + ", roomType="
				+ roomType + ", available=" + available + "]";
	}
}
