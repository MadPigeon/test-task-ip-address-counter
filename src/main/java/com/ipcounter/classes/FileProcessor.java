package com.ipcounter.classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileProcessor {

  public static long countUniqueIpsInFile(final String filePath) throws IOException {
    long result = 0;
    Path path = Paths.get(filePath);
    try (Stream<String> lines = Files.lines(path)) {
      CounterStorage storage = new CounterStorage();
      storage.storeIps(lines);
      result = storage.getCount();
    } catch (IOException e) {
      throw new IOException(path.toAbsolutePath().toString(), e);
    }

    return result;
  }

}