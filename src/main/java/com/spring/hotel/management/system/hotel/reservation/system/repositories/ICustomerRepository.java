/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.hotel.management.system.hotel.reservation.system.entity.Customer;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className ICustomerRepository.java
   @created 17-Oct-2020
 */
public interface ICustomerRepository extends JpaRepository<Customer, Long>{

}
