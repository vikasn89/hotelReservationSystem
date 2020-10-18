/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.spring.hotel.management.system.hotel.reservation.system.entity.Room;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className RoomTypeModel.java
   @created 18-Oct-2020
 */
public class RoomTypeModel
{

	private Long id;
	
	private String roomType;
	
	private Long pricePerNight;
	
	private String features;

	
	
	/**
	 * @param id
	 * @param roomType
	 * @param pricePerNight
	 * @param features
	 */
	public RoomTypeModel(Long id, String roomType, Long pricePerNight,
			String features) {
		super();
		this.id = id;
		this.roomType = roomType;
		this.pricePerNight = pricePerNight;
		this.features = features;
	}

	
	public RoomTypeModel() {
		super();
	}

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

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}
	
}
