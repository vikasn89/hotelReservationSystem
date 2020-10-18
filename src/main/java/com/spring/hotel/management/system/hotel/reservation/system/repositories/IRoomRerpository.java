/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.hotel.management.system.hotel.reservation.system.entity.Room;
import com.spring.hotel.management.system.hotel.reservation.system.entity.RoomType;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className IRoomRerpository.java
   @created 17-Oct-2020
 */

@Repository
public interface IRoomRerpository extends JpaRepository<Room, Long> {

	List<Room> findByRoomType(RoomType roomType);
	
	Optional<Room> findById(Long id);
	
	List<Room> findByRoomNo(String roomNo);
	
	List<Room> findByRoomTypeAndAvailable(RoomType roomType,Boolean available);
	
}
