/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotel.management.system.hotel.reservation.system.entity.Room;
import com.spring.hotel.management.system.hotel.reservation.system.entity.RoomType;
import com.spring.hotel.management.system.hotel.reservation.system.model.RoomModel;
import com.spring.hotel.management.system.hotel.reservation.system.repositories.IRoomRerpository;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className RoomService.java
   @created 18-Oct-2020
 */
@Service
public class RoomService 
{
	 private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);
	 
	 @Autowired
	 IRoomRerpository roomRepository;
	 
	 @Autowired
	 RoomTypeService roomTypeService;
	 
	public List<RoomModel> getRoomsByRoomType(RoomType roomType) throws Exception
	{
		List<Room> rooms = roomRepository.findByRoomType(roomType);
		return  rooms.stream().map(room -> RoomEntityToModelConvert(room)).collect(Collectors.toList());
	}
	 
	 @Transactional(rollbackOn = Exception.class)
		public List<RoomModel> getAvailableRoomsByRoomType(RoomType roomType) throws Exception
		{
			List<Room> rooms = roomRepository.findByRoomTypeAndAvailable(roomType, true);
			return  rooms.stream().map(room -> RoomEntityToModelConvert(room)).collect(Collectors.toList());
		}
	
	
	public Room RoomModelToEntityConvert(RoomModel roomModel)
	{
		Room roomEntity = new Room();
		if(roomModel!= null)
		{
			if(roomModel.getId()!= null) roomEntity.setId(roomModel.getId());
			if(roomModel.getRoomNo()!= null && roomModel.getRoomNo().isEmpty()== false) roomEntity.setRoomNo(roomModel.getRoomNo());
			if(roomModel.getRoomType()!= null) roomEntity.setRoomType(roomTypeService.RoomTypeModelToEntityConversion(roomModel.getRoomType()));
			if(roomModel.getAvailable()!= null) roomEntity.setAvailable(roomModel.getAvailable());
		}
		
		return roomEntity;
	}
	
	public RoomModel RoomEntityToModelConvert(Room roomEntity)
	{
		RoomModel roomModel = new RoomModel();
		if(roomEntity!= null)
		{
			if(roomEntity.getId()!= null) roomModel.setId(roomEntity.getId());
			if(roomEntity.getRoomNo()!= null && roomEntity.getRoomNo().isEmpty()== false) roomModel.setRoomNo(roomEntity.getRoomNo());
			if(roomEntity.getRoomType()!= null) roomModel.setRoomType(roomTypeService.RoomTypeEntityToModelConversion(roomEntity.getRoomType()));
			if(roomEntity.getAvailable()!= null) roomModel.setAvailable(roomEntity.getAvailable());
		}
		
		return roomModel;
	}
}
