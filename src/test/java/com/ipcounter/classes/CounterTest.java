package com.ipcounter.classes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class CounterTest {
  @Test
  public void countsTwoElements() {
    long actualResult = Counter.countUniqueAddresses(List.of("192.0.0.1", "255.255.255.255").stream());
    assertEquals(2, actualResult);
  }

  @Test
  public void countsZeroElements() {
    long actualResult = Counter.countUniqueAddresses(new ArrayList<String>().stream());
    assertEquals(0, actualResult);
  }

  @Test
  public void ignoresDuplicates() {
    long actualResult = Counter.countUniqueAddresses(List.of("192.0.0.1", "192.0.0.1").stream());
    assertEquals(1, actualResult);
  }
}
