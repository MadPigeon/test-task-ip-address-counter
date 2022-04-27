package com.ipcounter;

import java.io.IOException;
import java.util.Scanner;

import com.ipcounter.classes.FileProcessor;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Please provide a path to the file with the list of IPs:");
    String path = sc.nextLine();
    try {
      int uniqueAddressessCount = FileProcessor.countUniqueIpsInFile(path);
      System.out.println(String.format("There are %s unique addressess in the file.", uniqueAddressessCount));
    } catch (IOException e) {
      System.out.println("An error has occured.");
      System.out.println(e);
      System.out.println(e.getMessage());
    } finally {
      sc.close();
    }
  }
}
