package com.ipcounter;

import java.io.IOException;
import java.util.Scanner;

import com.ipcounter.classes.FileProcessor;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean finishedCounting = false;

    while (!finishedCounting) {
      System.out.println("Please provide a path to the file with the list of IPs:");
      String path = sc.nextLine();
      try {
        System.out.println("Counting the lines in file");
        FileProcessor processor = new FileProcessor(path);
        System.out.println("Starting the counting process, please wait.");
        processor.start();
        float percentage = 0;
        while (processor.isAlive()) {
          float newPercentage = processor.getPercentage();
          if (newPercentage > percentage) {
            percentage = newPercentage;
            System.out.println(percentage);
          }
        }
        if (processor.hasException()) {
          throw processor.getException();
        }
        long uniqueAddressessCount = processor.getCalculatedResult();
        System.out.println(String.format(
            "There are %s unique addressess in the file.", uniqueAddressessCount));
        finishedCounting = true;
      } catch (IOException e) {
        System.out.println("An error has occurred.");
        System.out.println(e);
        System.out.println(e.getMessage());
      }
    }
    sc.close();
  }
}
