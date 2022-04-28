package com.ipcounter.classes;

import java.util.BitSet;

public final class CounterStorage {

  private BitSet beforeZero;
  private BitSet afterAndIncludingZero;

  public CounterStorage() {
    beforeZero = new BitSet(Integer.MAX_VALUE);
    afterAndIncludingZero = new BitSet(Integer.MAX_VALUE);
  }

  public void storeIp(long ipAddress) {
    if (ipAddress > Integer.MAX_VALUE) {
      afterAndIncludingZero.set((int) (Integer.MIN_VALUE + ipAddress), true);
    } else {
      beforeZero.set((int) ipAddress, true);
    }
  }

  public long getCount() {
    long allAddresses = beforeZero.stream().count() + afterAndIncludingZero.stream().count();

    return allAddresses;
  }

}
