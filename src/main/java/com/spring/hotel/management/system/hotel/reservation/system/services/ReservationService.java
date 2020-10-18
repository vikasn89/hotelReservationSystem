/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.hotel.management.system.hotel.reservation.system.controller.ReservationRestController;
import com.spring.hotel.management.system.hotel.reservation.system.entity.Reservation;
import com.spring.hotel.management.system.hotel.reservation.system.model.ReservationModel;
import com.spring.hotel.management.system.hotel.reservation.system.repositories.IReservationRepository;
import com.spring.hotel.management.system.hotel.reservation.system.util.ConstantsUtil;
import com.spring.hotel.management.system.hotel.reservation.system.util.RuleEnum;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className ReservationService.java
   @created 17-Oct-2020
 */
@Service
public class ReservationService 
{
	 private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);
	 
	@Autowired
	IReservationRepository reservsationRepository;
	
	
	

	/**
	 * @param body 
	 * @Param
	   @return
	 */
	public ResponseEntity<?> checkRoomAvailability(Map<String, String> requestBody) throws Exception 
	{
		validateRoomAvailibilityFilelds(requestBody);
		
		return null;
	}
	
	/**
	 * @Param
	   @return
	 */
	private void validateRoomAvailibilityFilelds(Map<String, String> requestBody) throws Exception 
	{
		logger.debug("validateRoomAvailibilityFilelds: ");
	    List<HashMap<String, Object>> listOfMap = new ArrayList<HashMap<String, Object>>();
	    HashMap<Enum, String> rule = new HashMap<>();
	    List<HashMap<Enum, String>> validationRulesEnum = new ArrayList<HashMap<Enum, String>>();
	    HashMap<String, Object> fieldMap = new HashMap<>();
	    
	    // Validate userId field
	    fieldMap = new HashMap<>();
	    fieldMap.put(ConstantsUtil.FIELD_NAME, ConstantsUtil.ROOM_TYPE);
	    fieldMap.put(ConstantsUtil.FIELD_VALUE, requestBody.get(ConstantsUtil.ROOM_TYPE));
	    validationRulesEnum = new ArrayList<HashMap<Enum, String>>();
	    rule = new HashMap<>();
	    rule.put(RuleEnum.NOT_EMPTY, "message");
	    validationRulesEnum.add(rule);
	    fieldMap.put(ConstantsUtil.VALIDATION, validationRulesEnum);
	    listOfMap.add(fieldMap);
	    
	    fieldMap = new HashMap<>();
	    fieldMap.put(ConstantsUtil.FIELD_NAME, ConstantsUtil.CHECK_IN_DATE);
	    fieldMap.put(ConstantsUtil.FIELD_VALUE, requestBody.get(ConstantsUtil.USER_NAME));
	    validationRulesEnum = new ArrayList<HashMap<Enum, String>>();
	    rule = new HashMap<>();
	    rule.put(RuleEnum.NOT_EMPTY, "message");
	    validationRulesEnum.add(rule);
	    fieldMap.put(ConstantsUtil.VALIDATION, validationRulesEnum);
	    listOfMap.add(fieldMap);
	    
	    fieldMap = new HashMap<>();
	    fieldMap.put(ConstantsUtil.FIELD_NAME, ConstantsUtil.USER_NAME);
	    fieldMap.put(ConstantsUtil.FIELD_VALUE, requestBody.get(ConstantsUtil.USER_NAME));
	    validationRulesEnum = new ArrayList<HashMap<Enum, String>>();
	    rule = new HashMap<>();
	    rule.put(RuleEnum.NOT_EMPTY, "message");
	    validationRulesEnum.add(rule);
	    fieldMap.put(ConstantsUtil.VALIDATION, validationRulesEnum);
	    listOfMap.add(fieldMap);

	}
}
