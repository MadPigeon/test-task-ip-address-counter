package com.ipcounter.classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileProcessor {

  public static long countUniqueIpsInFile(final String filePath) throws IOException {
    long result = 0;
    try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
      result = Counter.countUniqueAddresses(lines);
    } catch (IOException e) {
      throw e;
    }
    
    return result;
  }

}