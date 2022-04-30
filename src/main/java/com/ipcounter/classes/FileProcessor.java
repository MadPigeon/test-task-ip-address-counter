package com.ipcounter.classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileProcessor extends Thread {

  private long result = 0;
  private long lineLength = 0;
  private long currentLine = 0;
  private final Path path;
  private IOException exception = null;

  public FileProcessor(final String filePath) {
    this.path = Paths.get(filePath);
    try (Stream<String> lines = Files.lines(path)) {
      this.lineLength = lines.count();
    } catch (IOException e) {
      this.exception = constructException(e);
    }
  }

  public float getPercentage() {
    if (lineLength == 0) {
      return 0;
    }
    return Float.valueOf(currentLine / lineLength);
  }

  public boolean hasException() {
    return exception != null;
  }

  public IOException getException() {
    return exception;
  }

  public long getCalculatedResult(){
    return result;
  }

  private IOException constructException(IOException baseException) {
    return new IOException(path.toAbsolutePath().toString(), baseException);
  }

  @Override
  public void run() {
    try (Stream<String> lines = Files.lines(path)) {
      CounterStorage storage = new CounterStorage();
      storage.storeIps(lines);
      result = storage.getCount();
    } catch (IOException e) {
      this.exception = constructException(e);
    }
  }

}