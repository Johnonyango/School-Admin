package com.john.view;

import com.john.logic.StudentLogic;
import com.john.logic.StudentLogicI;
import com.john.logic.TeacherLogic;
import com.john.model.Student;
import com.john.model.Teacher;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TeacherView implements TeacherViewI {
    Scanner scanner;
    TeacherLogic teacherLogic;

    public TeacherView() throws SQLException, ClassNotFoundException {
        scanner = new Scanner(System.in);
        teacherLogic = new TeacherLogic();
    }

    private void assignTeacher() throws SQLException {
        Teacher teacher = new Teacher();
        System.out.println("Enter name:");
        teacher.setName(scanner.nextLine());
        System.out.println("Enter registration #:");
        teacher.setStaffNo(scanner.nextLine());
        System.out.println("Enter course:");
        teacher.setCourse(scanner.nextLine());
        System.out.println("Enter ID #:");
        teacher.setId(scanner.nextLong());
        System.out.println("You are about to assign the following details:\n" + teacher.toString() + "\nContinue?\n1. Yes\n2. No");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1)
            teacherLogic.add(teacher);
    }
    private void show() throws SQLException{
        System.out.println("List of students from the DB");
        List<Teacher> teachers = teacherLogic.findAll();
        Iterator iterator = teachers.iterator();
        while(iterator.hasNext()){
            System.out.println(((Teacher) iterator.next()).toStringRow());
        }
    }

    @Override
    public void teacherMenu() throws SQLException {
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
            switch (option) {
                case 1:
                    this.assignTeacher();
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
        } while (option != 0);
        teacherLogic = null;
    }
}