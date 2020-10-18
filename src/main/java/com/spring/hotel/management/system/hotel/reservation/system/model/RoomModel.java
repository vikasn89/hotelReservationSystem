/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.model;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className RoomModel.java
   @created 18-Oct-2020
 */
public class RoomModel {

	private Long id;
	
	private String roomNo;
	
	private RoomTypeModel roomType;
	
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

	public RoomTypeModel getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomTypeModel roomType) {
		this.roomType = roomType;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
}
