package com.princely.training.fundamental.utils;

import com.princely.training.fundamental.enumeration.Gender;
import com.princely.training.fundamental.model.Student;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Tools {

  private Tools() {
  }

  static Scanner scanner = new Scanner(System.in);

  static Student[] students = new Student[100];

  static boolean flag = false;
  static int i = 0;

  //method to show operation list.
  public static void listOperations() {

    System.out.printf(
        "  1. Add new student %n" +
            "  2. View All student list %n" +
            "  3. view a student from the list %n" +
            "  4. Delete a student from the list %n" +
            "  5. Delete all student from the list %n" +
            "  6. Exit the program %n");

    System.out.println(" ");
  }

  //1. method that create new student.
  public static void createNewStudent() {
    int addMore;

    do {
      System.out.println(" ");
      System.out.println("        ENTER STUDENT INFORMATION");
      int sId = i + 1;

      System.out.println(" STUDENT ID : " + sId);

      System.out.print(" FIRST NAME : ");
      String firstName = scanner.next();

      System.out.print(" SECOND NAME : ");
      String secondName = scanner.next();

      System.out.print(" DATE OF BIRTH in format(dd-MM-yyyy) : ");
      String sDateOfBirth = scanner.next();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
      LocalDate bDate = LocalDate.parse(sDateOfBirth, formatter);

      System.out.print(" ADDRESS : ");
      String sAddress = scanner.next();

      System.out.print(" GENDER: press 1. MALE, | press 2. FEMALE : ");
      int gender = scanner.nextInt();
      Gender sGender = Gender.MALE;

      if (gender == 2) {
        sGender = Gender.FEMALE;


      }
      System.out.print(" To continue press 1 or press any number to go back to option : ");
      addMore = scanner.nextInt();

      students[i] = new Student(firstName, secondName, bDate, sAddress, sId, sGender);
      i++;


    } while (addMore == 1);

  }
}
