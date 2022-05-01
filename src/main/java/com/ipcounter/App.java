package com.ipcounter;

import java.io.IOException;
import java.util.Scanner;

import com.ipcounter.classes.FileProcessor;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean finishedCounting = false;

    // lets the user change the path after a mistake
    while (!finishedCounting) {
      System.out.println("Please provide a path to the file with the list of IPs:");
      String path = sc.nextLine();
      try {
        // creating a separate thread
        FileProcessor processor = new FileProcessor(path);
        System.out.println("Starting the counting process, please wait.");
        // running the process in a separate thread so we can show the progress
        processor.start();
        float lineNumber = 0;
        final int arbitraryBeautifulNumber = 1000;
        // while the counting continues we display the progress for every 1000 steps
        while (processor.isAlive()) {
          float updatedLineNumber = processor.getCurrentLine();
          if (updatedLineNumber > lineNumber &&
              updatedLineNumber % arbitraryBeautifulNumber == 0) {
            lineNumber = updatedLineNumber;
            System.out.println(lineNumber);
          }
        }
        // couldn't throw exceptions from the run() method of the thread FileProcessor
        processor.throwExceptionIfExists();
        long uniqueAddressessCount = processor.getCalculatedResult();
        System.out.println(String.format(
            "There are %s unique addressess in the file.", uniqueAddressessCount));
        // the user has gotten his answer and now the program may close
        finishedCounting = true;
      } catch (IOException e) {
        // trying to be as discriptive as I can, so everything gets printed
        System.out.println("An error has occurred.");
        System.out.println(e);
        System.out.println(e.getMessage());
      }
    }
    sc.close();
  }
}
