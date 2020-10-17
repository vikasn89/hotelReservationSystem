package com.spring.hotel.management.system.hotel.reservation.system.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="customer", uniqueConstraints ={@UniqueConstraint(name="customer_username_unq_index", columnNames = {"username"})})
public class Customer implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "CUSTOMER_SEQ")
	@SequenceGenerator(sequenceName = "CUSTOMER_SEQ", allocationSize = 1, name = "CUSTOMER_SEQ")
	private Long id;
	
	@Column(name="username", nullable = false)
	private String userName;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email_id", nullable = false)
	private String emailId;
	
	@Column(name="contact_no", nullable = false)
	private String contactNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId + ", contactNo=" + contactNo + "]";
	}
}
