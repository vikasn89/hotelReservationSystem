package com.spring.hotel.management.system.hotel.reservation.system.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import org.springframework.stereotype.Service;

/**
 *
 * Encrypts the given string into sha256
 * <p>
 *
 * Created on 10-Feb-2020 at 1:31:39 pm
 *
 * Package Name: org.unicef.mis.service
 *
 * Project Name: UNICEF_HVS_MIS
 *
 * @author Aparna Satpute
 * @author Rahul Babhare
 *
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

