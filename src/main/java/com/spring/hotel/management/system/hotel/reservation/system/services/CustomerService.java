/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.hotel.management.system.hotel.reservation.system.entity.Customer;
import com.spring.hotel.management.system.hotel.reservation.system.model.CustomerModel;
import com.spring.hotel.management.system.hotel.reservation.system.repositories.ICustomerRepository;
import com.spring.hotel.management.system.hotel.reservation.system.util.SHA256EncryptionUtil;


/**
 * @author Vikas Ramesh Kondvilkar
 * @className CustomerService.java
   @created 18-Oct-2020
 */
@Service
public class CustomerService implements UserDetailsService{

	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
	@Autowired
	ICustomerRepository customerRepository ;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Customer customer = customerRepository.findByUserName(username);
		if (customer == null) {
		      throw new UsernameNotFoundException("customer not found with username: " + username);
		    }
		    logger.debug("Moving out Method: loadUserByUsername");
		    return new org.springframework.security.core.userdetails.User(customer.getUserName(),
		    		customer.getPassword(), new ArrayList<>());
	}
	
	@Transactional(rollbackOn = Exception.class)
	public Customer registerCustomer(CustomerModel customerModel) throws Exception
	{
		Customer customerEntity = new Customer();
		customerEntity.setUserName(customerModel.getUserName());
		customerEntity.setPassword(SHA256EncryptionUtil.sha256encrypt(customerModel.getPassword()));
		customerEntity.setFirstName(customerModel.getFirstName());
		customerEntity.setLastName(customerModel.getLastName());
		customerEntity.setContactNo(customerModel.getContactNo());
		customerEntity.setEmailId(customerModel.getEmailId());
		Customer customer = customerRepository.save(customerEntity);
		return customer;
	}
	
	
}
