package com.spring.hotel.management.system.hotel.reservation.system.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.spring.hotel.management.system.hotel.reservation.system.util.ConstantsUtil;
import com.spring.hotel.management.system.hotel.reservation.system.util.RuleEnum;
import com.spring.hotel.management.system.hotel.reservation.system.util.SHA256EncryptionUtil;



/**
 * @author Vikas Ramesh Kondvilkar
 * @className ValidationRulesService.java
   @created 19-Oct-2020
 */
public class ValidationRulesService {

  private static Logger logger = LogManager.getLogger();

  public static void validate(List<HashMap<String, Object>> listOfMap,
      ValidationInterfaces.didValidate didValidate) throws Exception {
    ArrayList<HashMap<String, Enum>> errorMessage = new ArrayList<>();
    RuleEnum rule = null;
    HashMap<String, Enum> errorMap = new LinkedHashMap<>();
    for (int i = 0; i < listOfMap.size(); i++) {
      String field = listOfMap.get(i).get(ConstantsUtil.FIELD_NAME).toString();
      String value = (listOfMap.get(i).get(ConstantsUtil.FIELD_VALUE) != null)
          ? (listOfMap.get(i).get(ConstantsUtil.FIELD_VALUE).toString())
          : null;
      String dbValue = (listOfMap.get(i).get(ConstantsUtil.DB_VALUE) != null)
          ? (listOfMap.get(i).get(ConstantsUtil.DB_VALUE).toString())
          : null;

      List<HashMap<Enum, String>> validation =
          (List<HashMap<Enum, String>>) listOfMap.get(i).get(ConstantsUtil.VALIDATION);
      if (validation != null) {
        for (int j = 0; j < validation.size(); j++) {
          rule = (RuleEnum) validation.get(j).keySet().iterator().next();
          errorMap = validateRules(rule, validation.get(j), field, value, dbValue);
          if (!errorMap.isEmpty()) {
            logger.warn("validate: " + field + "| rule: " + rule + "| value:" + value);
            errorMessage.add(errorMap);
          }
        }
      }
    }
    if (errorMessage.isEmpty()) {
      didValidate.didValidate(true, errorMessage);
    } else {
      didValidate.didValidate(false, errorMessage);
    }
  }

  // defined all validation rules
  private static HashMap<String, Enum> validateRules(RuleEnum rule,
      HashMap<Enum, String> validationMap, String fieldName, String value, String dbValue)
      throws Exception {
    HashMap<String, Enum> errorMap = new LinkedHashMap<>();
    final String numberRegExp = "[0-9]+";
    switch (rule) {
      case NOT_EMPTY:
        if (value == null || value.trim().equals("")) {
          errorMap.put(fieldName, RuleEnum.NOT_EMPTY);
        }
        break;
      case CUSTOMER_NOT_EXIST:
        if (value != null && !value.equals("") && !value.equals(dbValue)) {
          errorMap.put(fieldName, RuleEnum.CUSTOMER_NOT_EXIST);
        }
        break;

      case SIX_DIGIT_PASSWORD:
        if (value != null && value.length() > 0 && value.length() < 6) {
          errorMap.put(fieldName, RuleEnum.SIX_DIGIT_PASSWORD);
        }
        break;
      case WRONG_PASSWORD:
        String encryptedPassword = SHA256EncryptionUtil.sha256encrypt(value);
        if (value != null && !encryptedPassword.equals(dbValue)) {
          errorMap.put(fieldName, RuleEnum.WRONG_PASSWORD);
        }
        break;

      case DEACTIVATE_USER:
        if (value != null && value.equals("false")) {
          errorMap.put(fieldName, RuleEnum.DEACTIVATE_USER);
        }
        break;

      case MISMATCH_PASSWORD:
        if (value != null && !value.equals(dbValue)) {
          errorMap.put(fieldName, RuleEnum.MISMATCH_PASSWORD);
        }
        break;
      case MANDATORY_FIELDS_NOT_EXIST:
        if (value == null || value.isEmpty()) {
          errorMap.put(fieldName, RuleEnum.MANDATORY_FIELDS_NOT_EXIST);
        }
        break;
      case MANDATORY_FIELDS_NOT_EXIST_SEARCH:
        if (!value.isEmpty() || value != null) {
          errorMap.put(fieldName, RuleEnum.MANDATORY_FIELDS_NOT_EXIST);
        }
        break;
      case USERID_NOT_PRESENT:
        if (value != null && !value.equals(dbValue)) {
          errorMap.put(fieldName, RuleEnum.USERID_NOT_PRESENT);
        }
        break;
      case ID_NOT_EXIST_IN_DB:
        if (value != null && !value.equals("") && !value.equals(dbValue)) {
          errorMap.put(fieldName, RuleEnum.ID_NOT_EXIST_IN_DB);
        }
        break;
      case ROOM_BOOKING_AFTER_SIX_MONTH:
      if (value != null && !value.equals("") && !value.equals(dbValue)) {
          errorMap.put(fieldName, RuleEnum.ROOM_BOOKING_AFTER_SIX_MONTH);
        }
        break;
      case PREVIOUS_DATE_SELECTED:
      if (value != null && !value.equals("") && !value.equals(dbValue)) {
          errorMap.put(fieldName, RuleEnum.PREVIOUS_DATE_SELECTED);
        }
        break;
      case WRONG_DATE_SELECTED:
      if (value != null && !value.equals("") && !value.equals(dbValue)) {
          errorMap.put(fieldName, RuleEnum.WRONG_DATE_SELECTED);
        }
        break;
      case WRONG_CHECK_OUT_DATE_SELECTED:
      if (value != null && !value.equals("") && !value.equals(dbValue)) {
          errorMap.put(fieldName, RuleEnum.WRONG_CHECK_OUT_DATE_SELECTED);
        }
        break;
      case ROOM_NOT_AVAILABLE:
      if (value != null && !value.equals("") && !value.equals(dbValue)) {
          errorMap.put(fieldName, RuleEnum.ROOM_NOT_AVAILABLE);
        }
        break;
     
    }
    return errorMap;
  }
}


