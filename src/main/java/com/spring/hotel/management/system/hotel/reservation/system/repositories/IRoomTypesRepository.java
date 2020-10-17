/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.hotel.management.system.hotel.reservation.system.entity.RoomType;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className IRoomTypesRepository.java
   @created 17-Oct-2020
 */
@Repository
public interface IRoomTypesRepository extends JpaRepository<RoomType, Long>
{
	
}
