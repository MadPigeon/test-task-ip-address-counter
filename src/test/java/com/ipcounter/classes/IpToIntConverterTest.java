package com.ipcounter.classes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IpToIntConverterTest {

  @Test
  public void getsFirstPartRight() {
    long actualResult = IpToIntConverter.turnIpAddressIntoInt("0.0.0.1");
    assertEquals(1, actualResult);
  }

  @Test
  public void getsSecondPartRight() {
    long actualResult = IpToIntConverter.turnIpAddressIntoInt("0.0.1.0");
    assertEquals(256, actualResult);
  }

  @Test
  public void getsThirdPartRight() {
    long actualResult = IpToIntConverter.turnIpAddressIntoInt("0.1.0.0");
    assertEquals(65536, actualResult);
  }

  @Test
  public void getsFourthPartRight() {
    long actualResult = IpToIntConverter.turnIpAddressIntoInt("1.0.0.0");
    assertEquals(16777216, actualResult);
  }

  @Test
  public void sustainsMaxValue() {
    long actualResult = IpToIntConverter.turnIpAddressIntoInt("255.255.255.255");
    assertEquals(4294967295l, actualResult);
  }

  @Test(expected=IllegalArgumentException.class)
  public void refusesBadValues() {
    IpToIntConverter.turnIpAddressIntoInt("-1.0.0.0");
  }

  @Test(expected=IllegalArgumentException.class)
  public void refusesShortIps() {
    IpToIntConverter.turnIpAddressIntoInt("192.168.0");
  }
}
