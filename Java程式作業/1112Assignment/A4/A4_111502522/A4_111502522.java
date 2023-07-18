/*
Assignment 4
Name: 劉俊吾
Student Number: 111502522
Course 2023-CE1002-A
*/
package A4_111502522;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class A4_111502522 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;
        int id;
        String department;
        String institute;
        int student_number;
        int command;

        Department CSIE = new Department("CSIE", "EECS");
        Department EE = new Department("EE", "EECS");
        Department MATH = new Department("MATH", "SCI");
        Institute EECS = new Institute("EECS");
        Institute SCI = new Institute("SCI");
        EECS.addDepartment(CSIE);
        EECS.addDepartment(EE);
        SCI.addDepartment(MATH);

        HashMap<String, Department> department_map = new HashMap<String, Department>();
        department_map.put("CSIE", CSIE);
        department_map.put("EE", EE);
        department_map.put("MATH", MATH);
        HashMap<String, Institute> institute_map = new HashMap<String, Institute>();
        institute_map.put("EECS", EECS);
        institute_map.put("SCI", SCI);

        while (true) {
            System.out.println(
                    "1.add student 2.show the number of students in a department 3.show all the students in a department 4.show the number of students in an institute 5.exit:");
            command = input.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Please input the student info name/id/department:");
                    name = input.next();
                    id = input.nextInt();
                    department = input.next();
                    Student new_student = new Student(name, id, department);
                    department_map.get(department).addStudent(new_student);
                    break;
                case 2:
                    System.out.println("Please input the department:");
                    department = input.next();
                    student_number = department_map.get(department).getTotalStudentsInDep();
                    System.out.println(student_number);
                    break;
                case 3:
                    System.out.println("Please input the department:");
                    department = input.next();
                    department_map.get(department).showDepStudents();
                    break;
                case 4:
                    System.out.println("Please input the institute:");
                    institute = input.next();
                    student_number = institute_map.get(institute).getTotalStudentsInInstitute();
                    System.out.println(student_number);
                    break;
                case 5:
                    input.close();
                    return;
            }
        }
    }

}

@SuppressWarnings("unused")
class Student {
    private String name;
    public int id;
    private String dept;

    Student(String new_name, int new_id, String new_dept) {
        name = new_name;
        id = new_id;
        dept = new_dept;
    }

    public String getName() {
        return name;
    }
}

@SuppressWarnings("unused")
class Department {
    private String name;
    private String Institute;
    private ArrayList<Student> students = new ArrayList<Student>();

    Department(String new_name, String new_Institute) {
        name = new_name;
        Institute = new_Institute;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getStudent() {
        return students;
    }

    public int getTotalStudentsInDep() {
        return students.size();
    }

    public void showDepStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getName());
        }
    }
}

@SuppressWarnings("unused")
class Institute {
    private String name;
    private int student_number;
    private ArrayList<Department> departments = new ArrayList<Department>();

    Institute(String new_name) {
        name = new_name;
    }

    public void addDepartment(Department new_department) {
        departments.add(new_department);
    }

    public int getTotalStudentsInInstitute() {
        student_number = 0;
        for (int i = 0; i < departments.size(); i++) {
            student_number += departments.get(i).getTotalStudentsInDep();
        }
        return student_number;
    }
}