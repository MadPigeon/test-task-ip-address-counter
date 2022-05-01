package com.ipcounter.classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileProcessor extends Thread {

  private long currentLine = 0;
  private final Path path;
  private IOException exception = null;
  CounterStorage storage;

  /**
   * Creates a thread that is ready to run on a given file
   * 
   * @param filePath relative or absolute path to the file
   * @throws IOException if file does not exist
   */
  public FileProcessor(final String filePath) throws IOException {
    this.path = Paths.get(filePath);
    if (!Files.exists(path)) {
      throw new IOException(
          String.format(
              "File %s does not exist",
              path.toAbsolutePath().toString()));
    }
    storage = new CounterStorage();
  }

  /**
   * Makes it easier to track progress in a big file.
   * Initially wanted to make it a percentage, but counting
   * lines in a large file took too long
   * 
   * @return number of the current line
   */
  public float getCurrentLine() {
    return currentLine;
  }

  /**
   * Added this method because couldn't add exception to the run() method
   * Removing exception from the class afterward in case of re-runs
   * 
   * @throws IOException that occured during run()
   */
  public void throwExceptionIfExists() throws IOException {
    if (exception == null) {
      return;
    }
    IOException exceptionWithAbsolutePath = addPathToException(exception);
    throw exceptionWithAbsolutePath;
  }

  public long getCalculatedResult() {
    return storage.getCount();
  }

  /**
   * Makes errors more descriptive, tests easier to perform
   * 
   * @param baseException the exception that had occured
   * @return
   */
  private IOException addPathToException(IOException baseException) {
    return new IOException(path.toAbsolutePath().toString(), baseException);
  }

  /**
   * The overriden method that runs in a separate thread while communicating its
   * process to the currentLine
   */
  @Override
  public void run() {
    try (Stream<String> ips = Files.lines(path)) {
      ips.forEach(ip -> {
        this.currentLine++;
        this.storage.storeIp(ip);
      });
      // can't throw exceptions from an overriden run() method
    } catch (IOException e) {
      this.exception = e;
    }
  }
}