/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.services;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.spring.hotel.management.system.hotel.reservation.system.Exceptions.CustomException;
import com.spring.hotel.management.system.hotel.reservation.system.entity.Customer;
import com.spring.hotel.management.system.hotel.reservation.system.entity.Reservation;
import com.spring.hotel.management.system.hotel.reservation.system.entity.Room;
import com.spring.hotel.management.system.hotel.reservation.system.entity.RoomType;
import com.spring.hotel.management.system.hotel.reservation.system.repositories.ICustomerRepository;
import com.spring.hotel.management.system.hotel.reservation.system.repositories.IReservationRepository;
import com.spring.hotel.management.system.hotel.reservation.system.repositories.IRoomRerpository;
import com.spring.hotel.management.system.hotel.reservation.system.repositories.IRoomTypesRepository;
import com.spring.hotel.management.system.hotel.reservation.system.util.ConstantsUtil;
import com.spring.hotel.management.system.hotel.reservation.system.util.RuleEnum;
import com.spring.hotel.management.system.hotel.reservation.system.util.SuccessResponse;

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
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	RoomTypeService roomTypeService;
	
	@Autowired
	IRoomTypesRepository roomTyperepository;
	
	@Autowired
	IRoomRerpository roomRepository;
	
	@Autowired
	IReservationRepository reservationRepository;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ICustomerRepository customerRepository;
	
	/**
	 * @param body 
	 * @Param
	   @return
	 */
	@Transactional
	public ResponseEntity<?> checkRoomAvailability(Map<String, String> requestBody) throws Exception 
	{
		validateRoomAvailibilityFilelds(requestBody);
		Reservation reservationEntity = new Reservation();
		
		RoomType roomtype= roomTyperepository.findByRoomType(requestBody.get(ConstantsUtil.ROOM_TYPE));
		LocalDate checkIndate = StringToLocalDate(requestBody.get(ConstantsUtil.CHECK_IN_DATE));
		LocalDate checkOutdate = StringToLocalDate(requestBody.get(ConstantsUtil.CHECK_OUT_DATE));
		int noOfGuests = Integer.valueOf(requestBody.get(ConstantsUtil.NO_OF_GUESTS));
		UUID randomUUid  = UUID.randomUUID();
		Room room = roomRepository.findByRoomType(roomtype).stream().findFirst().orElse(null);
		Long reservationNo = randomUUid.timestamp();
		 SuccessResponse successResponse = new SuccessResponse();
	 if(noOfGuests > roomtype.getCapacity())
		{
			successResponse.setMessage(ConstantsUtil.GUESTS_MORE_THAN_CAPACITY);
		    successResponse.setStatus(ConstantsUtil.STATUS_CODE_DATA_NOT_AVAILABLE);
		}else if(room!= null && room.getId()!= null)
		{	
				successResponse.setMessage(ConstantsUtil.AVAILABLE);
			    successResponse.setStatus(ConstantsUtil.STATUS_CODE_SUCCESS);
		}
		else {
			successResponse.setMessage(ConstantsUtil.NOT_AVAILABLE);
		    successResponse.setStatus(ConstantsUtil.STATUS_CODE_DATA_NOT_AVAILABLE);
		}
		
		
		    return new ResponseEntity<>(successResponse, HttpStatus.OK);
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
	    
	    LocalDate currentDate = LocalDate.parse(localDateToString(LocalDate.now()),ConstantsUtil.DATE_FORMATTER);
	    
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
	    fieldMap.put(ConstantsUtil.FIELD_NAME, ConstantsUtil.NO_OF_GUESTS);
	    fieldMap.put(ConstantsUtil.FIELD_VALUE, requestBody.get(ConstantsUtil.NO_OF_GUESTS));
	    validationRulesEnum = new ArrayList<HashMap<Enum, String>>();
	    rule = new HashMap<>();
	    rule.put(RuleEnum.NOT_EMPTY, "message");
	    validationRulesEnum.add(rule);
	    fieldMap.put(ConstantsUtil.VALIDATION, validationRulesEnum);
	    listOfMap.add(fieldMap);
	    
	    fieldMap = new HashMap<>();
	    fieldMap.put(ConstantsUtil.FIELD_NAME, ConstantsUtil.CHECK_IN_DATE);
	    fieldMap.put(ConstantsUtil.FIELD_VALUE, requestBody.get(ConstantsUtil.CHECK_IN_DATE));
	    validationRulesEnum = new ArrayList<HashMap<Enum, String>>();
	    rule = new HashMap<>();
	    rule.put(RuleEnum.NOT_EMPTY, "message");
	    validationRulesEnum.add(rule);
	    fieldMap.put(ConstantsUtil.VALIDATION, validationRulesEnum);
	    listOfMap.add(fieldMap);
	    if(requestBody.get(ConstantsUtil.CHECK_IN_DATE)!= null && requestBody.get(ConstantsUtil.CHECK_IN_DATE).isEmpty() == false)
	    {
	    	LocalDate checkIndate = StringToLocalDate(requestBody.get(ConstantsUtil.CHECK_IN_DATE));
	    	
	    	
	    	if(checkIndate.compareTo(currentDate)<0)
	    	{
	    		fieldMap = new HashMap<>();
	    	    fieldMap.put(ConstantsUtil.FIELD_NAME, ConstantsUtil.CHECK_IN_DATE);
	    	    fieldMap.put(ConstantsUtil.FIELD_VALUE, requestBody.get(ConstantsUtil.CHECK_IN_DATE));
	    	    validationRulesEnum = new ArrayList<HashMap<Enum, String>>();
	    	    rule = new HashMap<>();
	    	    rule.put(RuleEnum.PREVIOUS_DATE_SELECTED, "message");
	    	    validationRulesEnum.add(rule);
	    	    fieldMap.put(ConstantsUtil.VALIDATION, validationRulesEnum);
	    	    listOfMap.add(fieldMap);
	    	}else {
	    		
	    		long monthsBetween = ChronoUnit.MONTHS.between(YearMonth.from(currentDate), YearMonth.from(checkIndate));
			     if(monthsBetween>6)
			     {
			    	 fieldMap = new HashMap<>();
			    	    fieldMap.put(ConstantsUtil.FIELD_NAME, ConstantsUtil.CHECK_IN_DATE);
			    	    fieldMap.put(ConstantsUtil.FIELD_VALUE, requestBody.get(ConstantsUtil.CHECK_IN_DATE));
			    	    validationRulesEnum = new ArrayList<HashMap<Enum, String>>();
			    	    rule = new HashMap<>();
			    	    rule.put(RuleEnum.ROOM_BOOKING_AFTER_SIX_MONTH, "message");
			    	    validationRulesEnum.add(rule);
			    	    fieldMap.put(ConstantsUtil.VALIDATION, validationRulesEnum);
			    	    listOfMap.add(fieldMap);
			     }
	    	}
	    }

	    fieldMap = new HashMap<>();
	    fieldMap.put(ConstantsUtil.FIELD_NAME, ConstantsUtil.CHECK_OUT_DATE);
	    fieldMap.put(ConstantsUtil.FIELD_VALUE, requestBody.get(ConstantsUtil.CHECK_OUT_DATE));
	    validationRulesEnum = new ArrayList<HashMap<Enum, String>>();
	    rule = new HashMap<>();
	    rule.put(RuleEnum.NOT_EMPTY, "message");
	    validationRulesEnum.add(rule);
	    fieldMap.put(ConstantsUtil.VALIDATION, validationRulesEnum);
	    listOfMap.add(fieldMap);
	    
	    if(requestBody.get(ConstantsUtil.CHECK_OUT_DATE)!= null && requestBody.get(ConstantsUtil.CHECK_OUT_DATE).isEmpty() == false)
	    {
	    	LocalDate checkIndate = StringToLocalDate(requestBody.get(ConstantsUtil.CHECK_IN_DATE));
	    	LocalDate checkOutdate = StringToLocalDate(requestBody.get(ConstantsUtil.CHECK_OUT_DATE));
	    	
	    	if((checkOutdate.compareTo(currentDate)<0)|| (checkOutdate.compareTo(checkIndate)<0))
	    	{
	    		fieldMap = new HashMap<>();
	    	    fieldMap.put(ConstantsUtil.FIELD_NAME, ConstantsUtil.CHECK_OUT_DATE);
	    	    fieldMap.put(ConstantsUtil.FIELD_VALUE, requestBody.get(ConstantsUtil.CHECK_OUT_DATE));
	    	    validationRulesEnum = new ArrayList<HashMap<Enum, String>>();
	    	    rule = new HashMap<>();
	    	    rule.put(RuleEnum.WRONG_CHECK_OUT_DATE_SELECTED, "message");
	    	    validationRulesEnum.add(rule);
	    	    fieldMap.put(ConstantsUtil.VALIDATION, validationRulesEnum);
	    	    listOfMap.add(fieldMap);
	    	}
	    }
	     if(requestBody.get(ConstantsUtil.ROOM_TYPE)!= null && requestBody.get(ConstantsUtil.ROOM_TYPE).isEmpty()==false)
	     {
	    	 RoomType roomType = roomTyperepository.findByRoomType(requestBody.get(ConstantsUtil.ROOM_TYPE));
	    	 
	    	 List<Room> rooms = roomRepository.findByRoomType(roomType);
	    	 
	    	 if(rooms != null && rooms.isEmpty() == false) {
	    	 }else {
	    		 fieldMap = new HashMap<>();
		    	    fieldMap.put(ConstantsUtil.FIELD_NAME, ConstantsUtil.ROOM_TYPE);
		    	    fieldMap.put(ConstantsUtil.FIELD_VALUE, requestBody.get(ConstantsUtil.ROOM_TYPE));
		    	    validationRulesEnum = new ArrayList<HashMap<Enum, String>>();
		    	    rule = new HashMap<>();
		    	    rule.put(RuleEnum.ROOM_NOT_AVAILABLE, "message");
		    	    validationRulesEnum.add(rule);
		    	    fieldMap.put(ConstantsUtil.VALIDATION, validationRulesEnum);
		    	    listOfMap.add(fieldMap);
	    	 }
	    	 
	     }
	     
	     ValidationRulesService.validate(listOfMap, new ValidationInterfaces.didValidate() {

	         @Override
	         public void didValidate(boolean isSuccess, List<HashMap<String, Enum>> errorMessage)
	             throws NoSuchMessageException, CustomException {

	           logger.debug("didValidate:", errorMessage.toString());
	           if (!errorMessage.isEmpty()) {
	             logger.debug("didValidate: errorMessage-", errorMessage.toString());

	             RuleEnum rule = (RuleEnum) errorMessage.get(0).values().iterator().next();
	             if (rule.equals(RuleEnum.NOT_EMPTY)) {
	               throw new CustomException(messageSource.getMessage("validate.fields", null, null,Locale.ENGLISH));
	             }
	             if (rule.equals(RuleEnum.PREVIOUS_DATE_SELECTED)) {
		               throw new CustomException(messageSource.getMessage("validate.previousDate", null, null,Locale.ENGLISH));
		             }
	             if (rule.equals(RuleEnum.ROOM_BOOKING_AFTER_SIX_MONTH)) {
		               throw new CustomException(messageSource.getMessage("validate.sixMonthValidation", null, null,Locale.ENGLISH));
		             }
	             if (rule.equals(RuleEnum.WRONG_CHECK_OUT_DATE_SELECTED)) {
		               throw new CustomException(messageSource.getMessage("validate.wrongCheckOutDate", null, null,Locale.ENGLISH));
		             }
	             if (rule.equals(RuleEnum.ROOM_NOT_AVAILABLE)) {
		               throw new CustomException(messageSource.getMessage("validate.roomnotAvailable", null, null,Locale.ENGLISH));
		             }
	           }
	         }
	       });
	    
	}
	
	public String localDateToString(LocalDate date)
	{
		String dateString = null;
		if(date!= null)
		{
			dateString = date.format(ConstantsUtil.DATE_FORMATTER);
		}
		return dateString;
	}
	
	public LocalDate StringToLocalDate(String dateString)
	{
		LocalDate date = null ;
		if(dateString!= null && dateString.isEmpty()==false)
		{
			date = LocalDate.parse(dateString, ConstantsUtil.DATE_FORMATTER);
		}
		return date;
	}

	/**
	 * @Param
	   @return
	 * @throws Exception 
	 */
	public ResponseEntity<?> roomReservation(Map<String, String> requestBody) throws Exception {

		validateRoomAvailibilityFilelds(requestBody);
		Reservation reservationEntity = new Reservation();
		Customer customer  = new Customer();
		RoomType roomtype= roomTyperepository.findByRoomType(requestBody.get(ConstantsUtil.ROOM_TYPE));
		LocalDate checkIndate = StringToLocalDate(requestBody.get(ConstantsUtil.CHECK_IN_DATE));
		LocalDate checkOutdate = StringToLocalDate(requestBody.get(ConstantsUtil.CHECK_OUT_DATE));
		int noOfGuests = Integer.valueOf(requestBody.get(ConstantsUtil.NO_OF_GUESTS));
		UUID randomUUid  = UUID.randomUUID();
		Room room = roomRepository.findByRoomType(roomtype).stream().findFirst().orElse(null);
		Long reservationNo = randomUUid.timestamp();
		 SuccessResponse successResponse = new SuccessResponse();
		 int days = checkOutdate.compareTo(checkIndate);
		 
		 
		 String username = customerService.getCurrentLoggedInUser();
		 
		 if(username != null && username.isEmpty() == false)
		 {
			 customer = customerRepository.findByUserName(username);
		 }else {
			 successResponse.setMessage(ConstantsUtil.INVALID_USERNAME);
			    successResponse.setStatus(ConstantsUtil.STATUS_CODE_UNAUTHORIZED);
			    return new ResponseEntity<>(successResponse, HttpStatus.OK);
		 }
		 
		if(room!= null && room.getId()!= null)
		{	
			room.setAvailable(false);
			roomRepository.save(room);
			
			reservationEntity.setReservationNo(reservationNo.toString());
			reservationEntity.setRoom(room);
			reservationEntity.setCheckInDt(checkIndate);
			reservationEntity.setCheckOutDt(checkOutdate);
			reservationEntity.setCustomer(customer);
			reservationEntity.setNoOfGuests(noOfGuests);
			reservationEntity.setReservationAmount(days*roomtype.getPricePerNight());
			reservationRepository.save(reservationEntity);
			
		}else
		{
			successResponse.setMessage(ConstantsUtil.ERROR_MESSAGE);
		    successResponse.setStatus(ConstantsUtil.STATUS_CODE_DATA_NOT_AVAILABLE);
		    return new ResponseEntity<>(successResponse, HttpStatus.OK);
		}
		
		 successResponse.setMessage(ConstantsUtil.SUCCESS_MESSAGE);
		    successResponse.setStatus(ConstantsUtil.STATUS_CODE_SUCCESS);
		    return new ResponseEntity<>(successResponse, HttpStatus.OK);
	
	}

	/**
	 * @Param
	   @return
	 */
	public ResponseEntity<?> roomReservationDetails(Map<String, String> body) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Param
	   @return
	 */
	public ResponseEntity<?> roomCheckout(Map<String, String> body) {
		
		
		return null;
	}
}
