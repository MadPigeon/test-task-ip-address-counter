package com.ipcounter.classes;

final class IpToIntConverter {

  private static final int BYTE_SIZE = 256;
  private static final int IP_ADDRESS_LENGTH = 4;

  public static final long turnIpAddressIntoInt(final String address) {
    final String[] ip_parts = address.split("[.]");
    if (ip_parts.length != IP_ADDRESS_LENGTH) {
      throw new IllegalArgumentException(address + " has " + ip_parts.length + " parts instead of 4.");
    }
    long result = 0;
    for (int i = 0; i < IP_ADDRESS_LENGTH; i++) {
      final int power = 3 - i;
      final int ip = Integer.parseInt(ip_parts[i]);
      if (ip < 0 || 255 < ip) {
        throw new IllegalArgumentException(address + " has " + ip + " part that does not lie between 0 and 255.");
      }
      result += ip * Math.pow(BYTE_SIZE, power);
    }

    return result;
  }
}