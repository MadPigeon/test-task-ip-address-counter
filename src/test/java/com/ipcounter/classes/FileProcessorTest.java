package com.ipcounter.classes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

public class FileProcessorTest {

  @Test
  public void opensExistingFile() {
    try {
      long actualResult = FileProcessor.countUniqueIpsInFile("dataset/test.txt");
      assertEquals(3, actualResult);
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void tellsAboutMissingFIle() {
    final String path = "dataset/no-such-file.txt";
    try {
      FileProcessor.countUniqueIpsInFile(path);
      fail(String.format("Returns result without a file. Path(%s)", path));
    } catch (IOException e) {
    }
  }
}
