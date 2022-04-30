package com.ipcounter.classes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CounterStorageTest {

  @Test
  public void countsSingleIp() {
    CounterStorage storage = new CounterStorage();
    storage.storeSingleIp("127.0.0.1");
    long actualResult = storage.getCount();
    assertEquals(1, actualResult);
  }

  @Test
  public void countsTwoElements() {
    CounterStorage storage = new CounterStorage();
    storage.storeIps(List.of("192.0.0.1", "255.255.255.255").stream());
    long actualResult = storage.getCount();
    assertEquals(2, actualResult);
  }

  @Test
  public void countsZeroElements() {
    CounterStorage storage = new CounterStorage();
    storage.storeIps(new ArrayList<String>().stream());
    long actualResult = storage.getCount();
    assertEquals(0, actualResult);
  }

  @Test
  public void ignoresDuplicates() {
    CounterStorage storage = new CounterStorage();
    storage.storeIps(List.of("192.0.0.1", "192.0.0.1").stream());
    long actualResult = storage.getCount();
    assertEquals(1, actualResult);
  }
}
