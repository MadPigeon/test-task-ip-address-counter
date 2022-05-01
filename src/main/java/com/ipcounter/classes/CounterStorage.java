package com.ipcounter.classes;

import java.util.BitSet;

/**
 * Class that can store any number of unique valid IPs
 */
public final class CounterStorage {

  /*
   * BitSet is the best type I found for storing the flags (visited or not) of IPs
   * It requires integers as indexes so I need two of them becase the number of
   * unique valid IPs equals exactly 2 * Integer.MAX_VALUE
   */
  private BitSet beforeZero;
  private BitSet afterAndIncludingZero;

  public CounterStorage() {
    beforeZero = new BitSet(Integer.MAX_VALUE);
    afterAndIncludingZero = new BitSet(Integer.MAX_VALUE);
  }

  /**
   * Marks IP as existing
   * 
   * @param ipAddress valid IP address
   */
  public void storeIp(String ipAddress) {
    storeIp(IpConverter.convertToLong(ipAddress));
  }

  /**
   * This method hides the complexity of the storage of unique IPs,
   * which is exactly what I need so that it is easy to use.
   * I put small numbers in before zero and big numbers in after zero
   * 
   * @param ipAddress validated IP address turned into an easy to use long value
   */
  private void storeIp(long ipAddress) {
    if (ipAddress > Integer.MAX_VALUE) {
      afterAndIncludingZero.set((int) (Integer.MIN_VALUE + ipAddress), true);
    } else {
      beforeZero.set((int) ipAddress, true);
    }
  }

  /**
   * Counts all of the stored unique IP addressess
   * 
   * @return number of unique IP addressess
   */
  public long getCount() {
    long allAddressess = beforeZero.stream().count() + afterAndIncludingZero.stream().count();

    return allAddressess;
  }

}
