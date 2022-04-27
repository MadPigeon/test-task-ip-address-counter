package com.ipcounter.classes;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Counter {

  public static int countUniqueAddresses(Stream<String> stream) {
    int result = stream
        .map(textIpAddress -> IpToIntConverter.turnIpAddressIntoInt(textIpAddress))
        .collect(Collectors.groupingBy(Function.identity()))
        .size();
    return result;
  }

}
