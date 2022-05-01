package com.ipcounter.classes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CounterStorageTest {

  @Test
  public void createdEmpty() {
    CounterStorage storage = new CounterStorage();
    long actualResult = storage.getCount();
    assertEquals(0, actualResult);
  }

  @Test
  public void countsSingleIp() {
    CounterStorage storage = new CounterStorage();
    storage.storeIp("127.0.0.1");
    long actualResult = storage.getCount();
    assertEquals(1, actualResult);
  }

  @Test
  public void ignoresDuplicates() {
    CounterStorage storage = new CounterStorage();
    final String singleIp = "192.0.0.1";
    storage.storeIp(singleIp);
    storage.storeIp(singleIp);
    long actualResult = storage.getCount();
    assertEquals(1, actualResult);
  }

  @Test
  public void countsTwoElements() {
    CounterStorage storage = new CounterStorage();
    storage.storeIp("192.0.0.1");
    storage.storeIp("255.255.255.255");
    long actualResult = storage.getCount();
    assertEquals(2, actualResult);
  }
}
