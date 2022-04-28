package com.ipcounter.classes;

import java.util.stream.Stream;

public class Counter {

  public static long countUniqueAddresses(Stream<String> stream) {
    CounterStorage storage = new CounterStorage();
    stream
        .forEach(textIpAddress -> storage.storeIp(IpConverter.convertToLong(textIpAddress)));
    return storage.getCount();
  }

}
