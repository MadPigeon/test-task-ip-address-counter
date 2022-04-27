package com.ipcounter.classes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IpConverterTest {

  @Test
  public void getsFirstPartRight() {
    long actualResult = IpConverter.convertToLong("0.0.0.1");
    assertEquals(1, actualResult);
  }

  @Test
  public void getsSecondPartRight() {
    long actualResult = IpConverter.convertToLong("0.0.1.0");
    assertEquals(256, actualResult);
  }

  @Test
  public void getsThirdPartRight() {
    long actualResult = IpConverter.convertToLong("0.1.0.0");
    assertEquals(65536, actualResult);
  }

  @Test
  public void getsFourthPartRight() {
    long actualResult = IpConverter.convertToLong("1.0.0.0");
    assertEquals(16777216, actualResult);
  }

  @Test
  public void sustainsMaxValue() {
    long actualResult = IpConverter.convertToLong("255.255.255.255");
    assertEquals(4294967295l, actualResult);
  }

  @Test(expected=IllegalArgumentException.class)
  public void refusesBadValues() {
    IpConverter.convertToLong("-1.0.0.0");
  }

  @Test(expected=IllegalArgumentException.class)
  public void refusesShortIps() {
    IpConverter.convertToLong("192.168.0");
  }
}
