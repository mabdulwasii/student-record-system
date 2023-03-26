package com.princely.training.fundamental.model;

import com.princely.training.fundamental.enumeration.Gender;
import java.time.LocalDate;

public class Student {

  static Student[] students = new Student[100];

  static int currentId = 0;

  private String firstName;
  private String secondName;
  private LocalDate dateOfBirth;
  private String address ;
  private int id;
  private Gender gender;

  public Student(String firstName, String secondName, LocalDate dateOfBirth,
      String address, Gender gender) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.dateOfBirth = dateOfBirth;
    this.address = address;
    this.gender = gender;
    this.id = generateId();
    addNewStudent(this);
  }

  private static void addNewStudent(Student student) {
    students[Student.currentId - 1] = student;
  }

  private static int generateId() {
    Student.currentId++;
    return Student.currentId + 1;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public String getAddress() {
    return address;
  }

  public int getId() {
    return id;
  }

  public Gender getGender() {
    return gender;
  }
}
