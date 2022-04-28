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
        long uniqueAddressessCount = FileProcessor.countUniqueIpsInFile(path);
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
