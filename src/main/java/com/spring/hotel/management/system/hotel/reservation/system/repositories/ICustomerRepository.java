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

	/**
	 * Query yo fetch Customer details by his/her username 
	 * @Param userName
	   @return customer Object
	 */
	Customer findByUserName(String username);
	
	/**Query yo fetch Customer details by his/her username and password
	 * @Param username, password
	   @return customer Object
	 */
	Customer findByUserNameAndPassword(String username, String password);

}
