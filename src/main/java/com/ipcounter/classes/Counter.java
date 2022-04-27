package com.ipcounter.classes;

import java.util.stream.Stream;

public class Counter {

  public static int countUniqueAddresses(Stream<String> stream) {
    int count = (int) stream.count();
    return count;
  }

}
