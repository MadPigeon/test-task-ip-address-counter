package com.ipcounter.classes;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;

public class CounterTest {
  @Test
  public void countsSingleElement() {
    int actualResult = Counter.countUniqueAddresses(List.of("192.0.0.1", "255.255.255.255").stream());
    assertEquals(2, actualResult);
  }
}
