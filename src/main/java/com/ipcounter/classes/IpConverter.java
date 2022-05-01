package com.ipcounter.classes;

final class IpConverter {

  private static final int BYTE_SIZE = 256;
  private static final int IP_ADDRESS_LENGTH = 4;
  private static final int MAX_POWER = 3;

  /**
   * Gets the number value of the IP from the 256-based numeric system
   * 
   * @param address a valid IP address
   * @return numerical
   */
  public static final long convertToLong(final String address) {
    final String[] ip_parts = address.split("[.]");
    if (ip_parts.length != IP_ADDRESS_LENGTH) {
      throw new IllegalArgumentException(address + " has " + ip_parts.length + " parts instead of 4.");
    }
    long result = 0;
    for (int i = 0; i < IP_ADDRESS_LENGTH; i++) {
      final int power = MAX_POWER - i;
      final int ip = Integer.parseInt(ip_parts[i]);
      // part of an IP must be between 0 and 255 (byte_size is 256)
      if (ip < 0 || BYTE_SIZE <= ip) {
        throw new IllegalArgumentException(address + " has " + ip + " part that does not lie between 0 and 255.");
      }
      result += ip * Math.pow(BYTE_SIZE, power);
    }

    return result;
  }
}