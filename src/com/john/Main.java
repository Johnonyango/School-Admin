package com.john;

import com.john.model.Teacher;
import com.john.view.StudentView;
import com.john.view.TeacherView;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int option;
        StudentView studentView = new StudentView();
        TeacherView teacherView = new TeacherView();
        do {
            System.out.println("Welcome to School System:\n Please select an option:\n1. Manage Teachers\n2. Manage Students\n3. Exit");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    break;
                case 2:
                    studentView.studentMenu();
                    break;
                case 3:
                    teacherView.teacherMenu();
                case 4:

            }
        } while (option != 3);
    }
}
