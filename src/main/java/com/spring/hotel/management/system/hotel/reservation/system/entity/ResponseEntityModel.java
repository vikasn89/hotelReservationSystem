/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Vikas Ramesh Kondvilkar
 * @param <T>
 * @className ResponseEntityModel.java
   @created 17-Oct-2020
 */
public class ResponseEntityModel<T> 
{
	private int code;
	
	private String message;
	
	private List<T> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	
}
