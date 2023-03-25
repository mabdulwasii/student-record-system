package com.princely.training.fundamental;

import com.princely.training.fundamental.utils.Tools;
import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int operation;

    do {
      System.out.println("STUDENT REGISTRATION FORM PROGRAM WITH THE FOLLOWING OPTION");
      Tools.listOperations();
      System.out.print("Enter your prefer option : ");
      operation = scanner.nextInt();

      switch (operation) {
        case 1:
          //Create new student
          Tools.createNewStudent();
          System.out.println(" Student added successfully ");
          System.out.println(" ");
          break;
      }
    } while (true);
  }

}
