package com.ipcounter.classes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CounterStorageTest {

  @Test
  public void shouldAnswerWithTrue() {
    CounterStorage storage = new CounterStorage();
    storage.storeIp(3L);
    assertEquals(1, storage.getCount());
  }
}
