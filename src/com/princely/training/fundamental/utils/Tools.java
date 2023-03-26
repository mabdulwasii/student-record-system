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
  static int i = 0;

  //method to show operation list.
  public static void listOperations() {

    System.out.printf(
        "  1. Add new student %n" +
            "  2. View All student list %n" +
            "  3. view a student from the list %n" +
            "  4. Delete a student from the list %n" +
            "  5. Delete all student from the list %n" +
            "  6. Exit the program %n%n");
  }

  //1. method that create new student.
  public static void createNewStudent() {
    int addMore;

    do {
      System.out.println(" ");
      System.out.println("        ENTER STUDENT INFORMATION");

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

      new Student(firstName, secondName, bDate, sAddress, sGender);

      System.out.println(" Student added successfully\n");

      System.out.print(" To continue press 1 or press any number to go back to option : ");
      addMore = scanner.nextInt();

    } while (addMore == 1);

  }

  public static void viewAllStudents() {
    Student[] students = Student.getStudents();
    if (students.length == 0) {
      isEmptyMessage();
    }else {
      drawTable();
      for (Student student : students) {
        if (student != null) {
          System.out.printf(" | %-25S| %-10S| %-15S| %-15S| %-15S|%n",
              student.getFirstName() + " " + student.getSecondName(),
              student.getId(),
              student.getDateOfBirth(),
              student.getAddress(),
              student.getGender());
        } else {
          isEmptyMessage();
          break;
        }
      }
      System.out.println();
    }
  }

  private static void drawTable() {
    System.out.printf("            ------------------------------------------------------------------%n" +
            "            ||||||| D-HUB SOFTWARE INSTITUTE STUDENT REGISTRATION FORM |||||||%n" +
            " -------------------------------------------------------------------------------------------%n" +
            " | %-25s| %-10s| %-15s| %-15s| %-15s|%n",
        "  FULL NAME", "IDs", " DATE OF BIRTH", " ADDRESS", " GENDER");
    System.out.println(" -------------------------------------------------------------------------------------------");
  }

  private static void isEmptyMessage() {
    System.out.println(" Student list is empty, please go to option to add new student(s) thanks!!! \n");
  }
}
