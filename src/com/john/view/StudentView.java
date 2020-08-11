package com.john.view;

import com.john.logic.StudentLogic;
import com.john.logic.StudentLogicI;
import com.john.model.Student;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentView implements StudentViewI {
    Scanner scanner;
    StudentLogicI studentLogicI;
    public StudentView() throws SQLException, ClassNotFoundException  {
        scanner = new Scanner(System.in);
        studentLogicI = new StudentLogic();
    }

    private void register() throws SQLException{
        Student student = new Student();
        System.out.println("Enter name:");
        student.setName(scanner.nextLine());
        System.out.println("Enter registration #:");
        student.setRegistrationNo(scanner.nextLine());
        System.out.println("Enter course:");
        student.setCourse(scanner.nextLine());
        System.out.println("Enter ID #:");
        student.setIdNumber(scanner.nextLine());
        System.out.println("You are about to register the following details:\n" + student.toString() + "\nContinue?\n1. Yes\n2. No");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 1)
            studentLogicI.add(student);
    }

    private void show() throws SQLException{
        System.out.println("List of students from the DB");
        List<Student> students = studentLogicI.findAll();
        Iterator iterator = students.iterator();
        while(iterator.hasNext()){
            System.out.println(((Student) iterator.next()).toStringRow());
        }
    }

    @Override
    public void studentMenu() throws SQLException {
        int option;
        do {
            System.out.println("Welcome to Student Module. \n" +
                    "Please select an option: \n" +
                    "1. Register a student \n" +
                    "2. Edit a student \n" +
                    "3. Delete a student \n" +
                    "4. Show list of students \n" +
                    "0. Back to main menu \n");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:
                    this.register();
                    break;
                case 2:
                    // edit();
                    break;
                case 3:
                    // delete();
                    break;
                case 4:
                    this.show();
                    break;
                case 0:
                    break;
            }
        } while(option != 0);
        studentLogicI = null;
    }
}