/**
 * 
 */
package com.spring.hotel.management.system.hotel.reservation.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hotel.management.system.hotel.reservation.system.Exceptions.CustomException;
import com.spring.hotel.management.system.hotel.reservation.system.entity.Customer;
import com.spring.hotel.management.system.hotel.reservation.system.services.CustomerService;
import com.spring.hotel.management.system.hotel.reservation.system.services.ValidationInterfaces;
import com.spring.hotel.management.system.hotel.reservation.system.services.ValidationRulesService;
import com.spring.hotel.management.system.hotel.reservation.system.util.AuthenticationRequestModel;
import com.spring.hotel.management.system.hotel.reservation.system.util.ConstantsUtil;
import com.spring.hotel.management.system.hotel.reservation.system.util.RuleEnum;
import com.spring.hotel.management.system.hotel.reservation.system.util.SHA256EncryptionUtil;
import com.spring.hotel.management.system.hotel.reservation.system.util.SuccessResponse;

/**
 * @author Vikas Ramesh Kondvilkar
 * @className LoginController.java
   @created 16-Oct-2020
 */
@RestController
@RequestMapping(value = "/")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	  private AuthenticationManager authenticationManager;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	  private MessageSource messageSource;
	
	@PostMapping(value="login")
	public ResponseEntity<?> LoginCustomer( @Valid @RequestBody AuthenticationRequestModel authenticationRequest) throws Exception
	{
		 final String method = "loginMobileUser";
		    logger.debug("Entering: " + method);
		    logger.debug("RequestBody: " + authenticationRequest.toString());

		Customer user  = customerService.getCustomerByUserName(authenticationRequest.getUsername());
		 validateLoginCustomer(authenticationRequest, user);
		 
		 authenticationRequest
	        .setPassword(SHA256EncryptionUtil.sha256encrypt(authenticationRequest.getPassword()));
	    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	        authenticationRequest.getUsername(), authenticationRequest.getPassword()));

	    final UserDetails userDetails =
	        customerService.loadUserByUsername(authenticationRequest.getUsername());

	    SuccessResponse successResponse = new SuccessResponse();
	    successResponse.setMessage(ConstantsUtil.SUCCESS_MESSAGE);
	    successResponse.setStatus(ConstantsUtil.STATUS_CODE_SUCCESS);
	    logger.debug("Moving out: " + method);
	    return new ResponseEntity<>(successResponse, HttpStatus.OK);
	}

	@PostMapping(value="/logout")
	public ResponseEntity<?> logOutCustomer()
	{
		final String method = "logoutMobileUser";
	    logger.debug("Entering: " + method);
	    
	      SuccessResponse successResponse = new SuccessResponse();
	      successResponse.setMessage(ConstantsUtil.SUCCESS_MESSAGE);
	      successResponse.setStatus(ConstantsUtil.STATUS_CODE_SUCCESS);
	      return new ResponseEntity<>(successResponse, HttpStatus.OK);
	}
	
	/**
	 * @Param
	   @return
	 * @throws Exception 
	 */
	private void validateLoginCustomer(
			 AuthenticationRequestModel authenticationRequest,
			Customer user) throws Exception {

	    logger.debug("validateLoginMobileUser: ");
	    List<HashMap<String, Object>> listOfMap = new ArrayList<>();
	    LinkedHashMap<Enum, String> rule;
	    List<HashMap<Enum, String>> validationRulesEnum;	
	    // Validated username field
	    HashMap<String, Object> fieldMap = new HashMap<>();
	    fieldMap.put(ConstantsUtil.FIELD_NAME, ConstantsUtil.USER_NAME);
	    fieldMap.put(ConstantsUtil.FIELD_VALUE, authenticationRequest.getUsername());
	    if (user != null)
	      fieldMap.put(ConstantsUtil.DB_VALUE, user.getUserName());
	    validationRulesEnum = new ArrayList<HashMap<Enum, String>>();
	    rule = new LinkedHashMap<>();
	    rule.put(RuleEnum.CUSTOMER_NOT_EXIST, ConstantsUtil.API_MESSAGE);
	    validationRulesEnum.add(rule);
	    fieldMap.put(ConstantsUtil.VALIDATION, validationRulesEnum);
	    listOfMap.add(fieldMap);

	    // Validated password field
	    fieldMap = new HashMap<>();
	    fieldMap.put(ConstantsUtil.FIELD_NAME, ConstantsUtil.PASSWORD);
	    fieldMap.put(ConstantsUtil.FIELD_VALUE, authenticationRequest.getPassword());
	    if (user != null)
	      fieldMap.put(ConstantsUtil.DB_VALUE, user.getPassword());
	    validationRulesEnum = new ArrayList<HashMap<Enum, String>>();
	    rule = new LinkedHashMap<>();
	    rule.put(RuleEnum.SIX_DIGIT_PASSWORD, ConstantsUtil.API_MESSAGE);
	    validationRulesEnum.add(rule);
	    rule = new LinkedHashMap<>();
	    rule.put(RuleEnum.WRONG_PASSWORD, ConstantsUtil.API_MESSAGE);
	    validationRulesEnum.add(rule);
	    fieldMap.put(ConstantsUtil.VALIDATION, validationRulesEnum);
	    listOfMap.add(fieldMap);

	    // Validated deactivated user
	    if (user != null) {
	      fieldMap = new HashMap<>();
	      fieldMap.put(ConstantsUtil.FIELD_NAME, ConstantsUtil.DEACTIVATED_USER);
	      fieldMap.put(ConstantsUtil.FIELD_VALUE, user.getIsActive().toString());
	      validationRulesEnum = new ArrayList<HashMap<Enum, String>>();
	      rule = new LinkedHashMap<>();
	      rule.put(RuleEnum.DEACTIVATE_USER, ConstantsUtil.API_MESSAGE);
	      validationRulesEnum.add(rule);
	      fieldMap.put(ConstantsUtil.VALIDATION, validationRulesEnum);
	      listOfMap.add(fieldMap);
	    }
	    ValidationRulesService.validate(listOfMap, new ValidationInterfaces.didValidate() {
	        public void didValidate(boolean isSuccess, List<HashMap<String, Enum>> errorMessage)
	            throws NoSuchMessageException, CustomException {

	          logger.debug("didValidate: " + errorMessage.toString());
	          if (!errorMessage.isEmpty()) {
	            logger.debug("didValidate: errorMessage-" + errorMessage.toString());
	            RuleEnum rule = (RuleEnum) errorMessage.get(0).values().iterator().next();
	            switch (rule) {
	              case CUSTOMER_NOT_EXIST:
	                throw new CustomException(messageSource.getMessage("validate.userNotExist", null,
	                    LocaleContextHolder.getLocale()));
	              case SIX_DIGIT_PASSWORD:
	                throw new CustomException(messageSource.getMessage("validate.password", null, null,
	                    LocaleContextHolder.getLocale()));
	              case WRONG_PASSWORD:
	                if (Boolean.FALSE.equals(user.getIsActive()))  {
	                  throw new CustomException(messageSource.getMessage("validate.userDeactivated", null,
	                      null, LocaleContextHolder.getLocale()));
	                }
	              case DEACTIVATE_USER:
	                throw new CustomException(messageSource.getMessage("validate.userDeactivated", null,
	                    null, LocaleContextHolder.getLocale()));
	              default:
	                break;
	            }
	          }
	        }
	      });
	}

}
