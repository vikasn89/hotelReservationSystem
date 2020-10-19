package com.spring.hotel.management.system.hotel.reservation.system.Exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.spring.hotel.management.system.hotel.reservation.system.util.ConstantsUtil;
import com.spring.hotel.management.system.hotel.reservation.system.util.ErrorResponse;


/**
 * @author Vikas Ramesh Kondvilkar
 * @className CustomExceptionHandler.java
   @created 19-Oct-2020
 */
@ControllerAdvice
public class CustomExceptionHandler {

  private static Logger logger = LogManager.getLogger();

  /**
   * @param ex
   * @param request
   * @return
   */
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
    final String method = "handleAllExceptions";
    logger.debug("Entering: " + method);
    StringWriter sw = new StringWriter();
    ex.printStackTrace(new PrintWriter(sw));
    String exceptionAsString = sw.toString();

    ErrorResponse error = new ErrorResponse(ConstantsUtil.STATUS_CODE_SERVER_ERROR,
        ConstantsUtil.SERVER_EXCEPTION, exceptionAsString);

    logger.error("Exception: ", ex);
    logger.debug("Moving out: " + method);
    return new ResponseEntity<>(error, HttpStatus.OK);
  }

  /**
   * @param ex
   * @param request
   * @return
   */
  @ExceptionHandler(CustomException.class)
  public final ResponseEntity<ErrorResponse> httpMessageNotReadable(CustomException ex,
      WebRequest request) {
    final String method = "httpMessageNotReadable";
    logger.debug("Entering: " + method);
    logger.error("Custom Exception:" + ex.getMessage());
    ErrorResponse errorResponse =
        new ErrorResponse(ConstantsUtil.STATUS_CODE_UNPROCESSABLE_ENTITY, ex.getMessage());
    logger.debug("Moving out: " + method);
    return new ResponseEntity<>(errorResponse, HttpStatus.OK);
  }

  @ExceptionHandler(DuplicateRequestCustomException.class)
  public final ResponseEntity<ErrorResponse> httpDuplicateRequest(
      DuplicateRequestCustomException ex, WebRequest request) {
    final String method = "httpDuplicateRequest";
    logger.debug("Entering: " + method);
    logger.error("Custom Exception:" + ex.getMessage());
    ErrorResponse errorResponse =
        new ErrorResponse(ConstantsUtil.STATUS_CODE_CONFLICT, ex.getMessage());
    logger.debug("Moving out: " + method);
    return new ResponseEntity<>(errorResponse, HttpStatus.OK);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public final ResponseEntity<ErrorResponse> httpDuplicateRequest(
      DataIntegrityViolationException ex, WebRequest request) {
    final String method = "httpDuplicateRequest";
    logger.debug("Entering: " + method);
    logger.error("Custom Exception:" + ex.getMessage());
    ErrorResponse errorResponse =
        new ErrorResponse(ConstantsUtil.STATUS_CODE_CONFLICT, ex.getMessage());
    logger.debug("Moving out: " + method);
    return new ResponseEntity<>(errorResponse, HttpStatus.OK);
  }

  /**
   * @param ex
   * @param request
   * @return
   */
  @ExceptionHandler(ConstraintViolationException.class)
  public final ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex,
      WebRequest request) {
    final String method = "handleConstraintViolation";
    logger.debug("Entering: " + method);
    List<String> errors = new ArrayList<>();
    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
      errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": "
          + violation.getMessage());
    }
    logger.error(ex.getLocalizedMessage() + "-" + errors);
    logger.error("ConstraintViolationException: ", ex);
    ErrorResponse errorResponse =
        new ErrorResponse(ConstantsUtil.STATUS_CODE_UNPROCESSABLE_ENTITY, errors.toString());
    logger.debug("Moving out: " + method);
    return new ResponseEntity<>(errorResponse, HttpStatus.OK);
  }


  /**
   * @param ex
   * @param request
   * @return
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public final ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatch(
      MethodArgumentNotValidException ex, WebRequest request) {
    final String method = "handleMethodArgumentTypeMismatch";
    logger.debug("Entering: " + method);
    List<String> details = new ArrayList<>();
    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      details.add(error.getDefaultMessage());
      logger.error("message-" + error.getDefaultMessage());
    }
    logger.error(ex.getLocalizedMessage() + "-" + details);
    logger.error("MethodArgumentNotValidException: ", ex);
    ErrorResponse errorResponse =
        new ErrorResponse(ConstantsUtil.STATUS_CODE_UNPROCESSABLE_ENTITY, details.get(0));
    logger.debug("Moving out: " + method);
    return new ResponseEntity<>(errorResponse, HttpStatus.OK);
  }

  /**
   * @param ex
   * @param request
   * @return
   */
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public final ResponseEntity<ErrorResponse> httpRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException ex, WebRequest request) {
    final String method = "httpRequestMethodNotSupported";
    logger.debug("Entering: " + method);
    logger.error("HttpRequestMethodNotSupportedException: ", ex);
    ErrorResponse errorResponse = new ErrorResponse(ConstantsUtil.STATUS_CODE_UNPROCESSABLE_ENTITY,
        "Request method not supported");
    logger.debug("Moving out: " + method);
    return new ResponseEntity<>(errorResponse, HttpStatus.OK);
  }

  /**
   * @param ex
   * @param request
   * @return
   */
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public final ResponseEntity<ErrorResponse> httpMessageNotReadable(
      HttpMessageNotReadableException ex, WebRequest request) {
    final String method = "httpMessageNotReadable";
    logger.debug("Entering: " + method);
    logger.error("HttpMessageNotReadableException: ", ex);
    ErrorResponse errorResponse =
        new ErrorResponse(ConstantsUtil.STATUS_CODE_UNPROCESSABLE_ENTITY, "Incorrect request body");
    logger.debug("Moving out: " + method);
    return new ResponseEntity<>(errorResponse, HttpStatus.OK);
  }
}
