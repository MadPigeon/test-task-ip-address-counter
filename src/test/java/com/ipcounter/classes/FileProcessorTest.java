package com.ipcounter.classes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

public class FileProcessorTest {

  @Test
  public void opensExistingFile() {
    try {
      FileProcessor processor = new FileProcessor("dataset/test.txt");
      processor.run();
      if (processor.hasException()) {
        throw processor.getException();
      }
      long actualResult = processor.getCalculatedResult();
      assertEquals(3, actualResult);
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void tellsAboutMissingFIle() {
    final String path = "dataset/no-such-file.txt";
    try {
      FileProcessor processor = new FileProcessor(path);
      processor.run();
      if (processor.hasException()) {
        throw processor.getException();
      }
      fail(String.format("Returns result without a file. Path(%s)", path));
    } catch (IOException e) {
    }
  }
}
