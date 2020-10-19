package com.spring.hotel.management.system.hotel.reservation.system.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import org.springframework.stereotype.Service;


/**
 * @author Vikas Ramesh Kondvilkar
 * @className SHA256EncryptionUtil.java
   @created 19-Oct-2020
 */
@Service
public class SHA256EncryptionUtil {

  public static String sha256encrypt(String ar) throws Exception {
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    byte[] hashInBytes = md.digest(ar.getBytes(StandardCharsets.UTF_8));

    // bytes to hex
    StringBuilder sb = new StringBuilder();
    for (byte b : hashInBytes) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();

  }

}

