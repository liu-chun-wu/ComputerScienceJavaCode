/*
Assignment 8
Name: 劉俊吾
Student Number: 111502522
Course 2023-CE1002-A
*/
package A8_111502522;

import java.util.Scanner;
import java.util.ArrayList;

public class A8_111502522 {
    public static void main(String args[]) {
        int x_pos, y_pos;
        String user_name, sheet_name, collaborater_name, unprocessed_value;
        Scanner input = new Scanner(System.in);
        ArrayList<user> user_list = new ArrayList<user>();
        boolean sheet_exist;
        while (true) {
            System.out.println("----------Menu----------");
            System.out.println("1. Create a user");
            System.out.println("2. Create a sheet");
            System.out.println("3. Check a sheet");
            System.out.println("4. Change a value in a sheet");
            System.out.println("5. Change a sheet's access right");
            System.out.println("6. Collaborate with another user");
            System.out.println("7. Exit");
            System.out.println("-------------------------");
            switch (input.nextInt()) {
                case 1:
                    user_name = input.next();
                    user new_user = new user(user_name);
                    user_list.add(new_user);
                    System.out.println("");
                    System.out.print("Create a user named \"");
                    System.out.print(user_name);
                    System.out.println("\"");
                    System.out.println("");
                    break;
                case 2:
                    user_name = input.next();
                    sheet_name = input.next();
                    for (int i = 0; i < user_list.size(); i++) {
                        if (user_list.get(i).get_user_name().equals(user_name)) {
                            sheet new_sheet = new sheet(sheet_name);
                            user_list.get(i).add_sheet(new_sheet);
                            System.out.println("");
                            System.out.print("Create a sheet named \"");
                            System.out.print(sheet_name);
                            System.out.print("\" for \"");
                            System.out.print(user_name);
                            System.out.println("\"");
                            System.out.println("");
                            break;
                        }
                    }
                    break;
                case 3:
                    user_name = input.next();
                    sheet_name = input.next();
                    for (int i = 0; i < user_list.size(); i++) {
                        if (user_list.get(i).get_user_name().equals(user_name)) {
                            System.out.println("");
                            user_list.get(i).get_sheet(sheet_name).show_data();
                            System.out.println("");
                            break;
                        }
                    }
                    break;
                case 4:
                    user_name = input.next();
                    sheet_name = input.next();
                    sheet_exist = false;
                    for (int i = 0; i < user_list.size(); i++) {
                        if (user_list.get(i).check_sheet_exist(sheet_name) == true) {

                            System.out.println("");
                            user_list.get(i).get_sheet(sheet_name).show_data();
                            System.out.println("");

                            y_pos = input.nextInt();
                            x_pos = input.nextInt();
                            unprocessed_value = input.next();

                            System.out.println("");
                            user_list.get(i).get_sheet(sheet_name).change_data(y_pos, x_pos, unprocessed_value,
                                    user_name);
                            System.out.println("");
                            user_list.get(i).get_sheet(sheet_name).show_data();
                            System.out.println("");

                            sheet_exist = true;
                            break;
                        }
                    }
                    if (sheet_exist == false) {
                        System.out.println("");
                        System.out.println("This sheet is not accessible");
                        System.out.println("");
                    }
                    break;
                case 5:
                    user_name = input.next();
                    sheet_name = input.next();
                    sheet_exist = true;
                    for (int i = 0; i < user_list.size(); i++) {
                        if (user_list.get(i).check_sheet_exist(sheet_name) == true
                                && user_list.get(i).get_user_name().equals(user_name)) {
                            System.out.println("");
                            System.out.print(user_name);
                            System.out.print(" ");
                            System.out.print(sheet_name);
                            System.out.print(" ");
                            System.out.println(user_list.get(i).get_sheet(sheet_name).change_access_status());
                            System.out.println("");
                            sheet_exist = false;
                            break;
                        }
                    }
                    if (sheet_exist == true) {
                        System.out.println("");
                        System.out.println("This sheet is not accessible");
                        System.out.println("");
                    }
                    break;
                case 6:
                    user_name = input.next();
                    sheet_name = input.next();
                    collaborater_name = input.next();
                    for (int i = 0; i < user_list.size(); i++) {
                        if (user_list.get(i).get_user_name().equals(user_name)) {
                            user_list.get(i).get_sheet(sheet_name).add_Collaborater(collaborater_name);
                            break;
                        }
                    }
                    System.out.println("");
                    System.out.print("Share \"");
                    System.out.print(user_name);
                    System.out.print("\"\'s \"");
                    System.out.print(sheet_name);
                    System.out.print("\" with \"");
                    System.out.print(collaborater_name);
                    System.out.println("\"");
                    System.out.println("");
                    break;
                case 7:
                    input.close();
                    return;
            }
        }
    }

}

class sheet {
    private int temp;
    private String sheet_name;
    private String access_status = "Editable";
    private double[][] data = new double[5][5];
    private ArrayList<String> Collaborater_list = new ArrayList<String>();
    private boolean can_access_data;
    private double processed_value;

    sheet(String name) {
        this.sheet_name = name;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                data[i][j] = 0;
            }
        }
    }

    public String get_sheet_name() {
        return sheet_name;
    }

    public void change_data(int y_pos, int x_pos, String unprocessed_value, String user_name) {
        can_access_data = false;
        processed_value = calculate.cal(unprocessed_value);
        for (int i = 0; i < Collaborater_list.size(); i++) {
            if (Collaborater_list.get(i).equals(user_name) && access_status.equals("Editable")) {
                data[y_pos][x_pos] = processed_value;
                can_access_data = true;
                break;
            }
        }
        if (can_access_data == false) {
            System.out.println("This sheet is not accessible");
        }
    }

    public void show_data() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 4) {
                    temp = (int) data[i][j];
                    if (data[i][j] - temp == 0.0) {
                        System.out.print(temp);
                        System.out.println(",");
                    } else {
                        System.out.print(data[i][j]);
                        System.out.println(",");
                    }
                } else {
                    temp = (int) data[i][j];
                    if (data[i][j] - temp == 0.0) {
                        System.out.print(temp);
                        System.out.print(", ");
                    } else {
                        System.out.print(data[i][j]);
                        System.out.print(", ");
                    }
                }
            }
        }
    }

    public String change_access_status() {
        if (access_status.equals("Editable")) {
            access_status = "ReadOnly";
        } else {
            access_status = "Editable";
        }
        return access_status;
    }

    public void add_Collaborater(String new_Collaborater) {
        Collaborater_list.add(new_Collaborater);
    }
}

class user {
    private sheet temp;
    private String user_name;
    private ArrayList<sheet> sheet_list = new ArrayList<sheet>();
    private boolean sheet_exist;

    user(String user_name) {
        this.user_name = user_name;
    }

    public String get_user_name() {
        return user_name;
    }

    public void add_sheet(sheet new_sheet) {
        sheet_list.add(new_sheet);
        new_sheet.add_Collaborater(user_name);
    }

    public boolean check_sheet_exist(String sheet_name) {
        sheet_exist = false;
        for (int i = 0; i < sheet_list.size(); i++) {
            if (sheet_list.get(i).get_sheet_name().equals(sheet_name)) {
                sheet_exist = true;
                break;
            }
        }
        return sheet_exist;
    }

    public sheet get_sheet(String sheet_name) {
        for (int i = 0; i < sheet_list.size(); i++) {
            if (sheet_list.get(i).get_sheet_name().equals(sheet_name)) {
                temp = sheet_list.get(i);
                break;
            }
        }
        return temp;
    }
}

class calculate {
    private static double first_num, second_num, result;
    private static boolean only_number = true;

    public static double cal(String unprocessed_value) {
        for (int i = 0; i < unprocessed_value.length(); i++) {
            if (unprocessed_value.charAt(i) == '+') {
                first_num = Double.parseDouble(unprocessed_value.substring(0, i));
                second_num = Double.parseDouble(unprocessed_value.substring(i + 1));
                result = first_num + second_num;
                only_number = false;
                break;
            } else if (unprocessed_value.charAt(i) == '-') {
                first_num = Double.parseDouble(unprocessed_value.substring(0, i));
                second_num = Double.parseDouble(unprocessed_value.substring(i + 1));
                result = first_num - second_num;
                only_number = false;
                break;
            } else if (unprocessed_value.charAt(i) == '*') {
                first_num = Double.parseDouble(unprocessed_value.substring(0, i));
                second_num = Double.parseDouble(unprocessed_value.substring(i + 1));
                result = first_num * second_num;
                only_number = false;
                break;
            } else if (unprocessed_value.charAt(i) == '/') {
                first_num = Double.parseDouble(unprocessed_value.substring(0, i));
                second_num = Double.parseDouble(unprocessed_value.substring(i + 1));
                result = first_num / second_num;
                only_number = false;
                break;
            }
        }
        if (only_number == true) {
            result = Double.parseDouble(unprocessed_value);
        }
        return result;
    }
}