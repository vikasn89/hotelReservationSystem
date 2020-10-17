/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.hotel.management.system.hotel.reservation.system.entity.Reservation;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className IReservationRepository.java
   @created 17-Oct-2020
 */
@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long>{

}
