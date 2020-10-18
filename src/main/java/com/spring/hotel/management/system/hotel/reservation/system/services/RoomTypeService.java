/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotel.management.system.hotel.reservation.system.entity.RoomType;
import com.spring.hotel.management.system.hotel.reservation.system.model.RoomTypeModel;
import com.spring.hotel.management.system.hotel.reservation.system.repositories.IRoomTypesRepository;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className RoomTypeService.java
   @created 18-Oct-2020
 */
@Service
public class RoomTypeService {

	 private static final Logger logger = LoggerFactory.getLogger(RoomTypeService.class);
	 
	 @Autowired
	 IRoomTypesRepository roomTypeRepository;
	 
	 
	 public List<RoomTypeModel> getAllRoomTypes()
	 {
		 List<RoomType> roomtypes = roomTypeRepository.findAll();
		 
		 @SuppressWarnings("unchecked")
		List<RoomTypeModel> roomTypeModels = ((Stream<RoomTypeModel>) Optional.ofNullable(roomtypes).orElse((List<RoomType>) roomtypes.stream().map(room -> new RoomTypeModel(room.getId(), room.getRoomType(), room.getPricePerNight(), room.getFeatures())))).collect(Collectors.toList());
		 
		 return roomTypeModels;
	 }
	 
	 public RoomTypeModel getRoomTypeById(Long id)
	 {
		 Optional<RoomType> roomTypesById = roomTypeRepository.findById(id);
		 RoomTypeModel roomTypeModel = new RoomTypeModel();
		 if(roomTypesById != null && roomTypesById.isPresent())
		 { 
			 RoomType roomTypeById = roomTypesById.get();
			 roomTypeModel =  new RoomTypeModel(roomTypeById.getId(), roomTypeById.getRoomType(), roomTypeById.getPricePerNight(), roomTypeById.getFeatures());
		 }
		 return roomTypeModel;
	 }
	 
	 public RoomTypeModel getRoomTypeByType(String type)
	 {
		 RoomType roomTypeById = roomTypeRepository.findByRoomType(type);
		 RoomTypeModel roomTypeModel = new RoomTypeModel();
		 if(roomTypeById != null && roomTypeById.getId()!= null)
		 { 
			 roomTypeModel = new RoomTypeModel(roomTypeById.getId(), roomTypeById.getRoomType(), roomTypeById.getPricePerNight(), roomTypeById.getFeatures());
		 }
		 return roomTypeModel;
	 }
}
