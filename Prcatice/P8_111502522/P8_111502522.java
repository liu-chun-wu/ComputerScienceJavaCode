/*
Practice 8
Name: 劉俊吾
Student Number: 111502522
Course 2023-CE1004-A
*/
package P8_111502522;

import java.util.Scanner;
import java.util.ArrayList;

public class P8_111502522 {
    public static void main(String args[]) {
        int x_pos, y_pos;
        String user_name, sheet_name, unprocessed_value;
        double processed_value;
        Scanner input = new Scanner(System.in);
        ArrayList<user> user_list = new ArrayList<user>();

        while (true) {
            System.out.println("----------Menu----------");
            System.out.println("1. Create a user");
            System.out.println("2. Create a sheet");
            System.out.println("3. Check a sheet");
            System.out.println("4. Change a value in a sheet");
            System.out.println("5. Change a sheet's access right");
            System.out.println("6. Exit");
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
                    for (int i = 0; i < user_list.size(); i++) {
                        if (user_list.get(i).get_user_name().equals(user_name)) {
                            System.out.println("");
                            user_list.get(i).get_sheet(sheet_name).show_data();
                            System.out.println("");
                            y_pos = input.nextInt();
                            x_pos = input.nextInt();
                            unprocessed_value = input.next();
                            processed_value = calculate.cal(unprocessed_value);
                            user_list.get(i).get_sheet(sheet_name).change_data(y_pos, x_pos, processed_value);
                            System.out.println("");
                            user_list.get(i).get_sheet(sheet_name).show_data();
                            System.out.println("");
                            break;
                        }
                    }
                    break;
                case 5:
                    user_name = input.next();
                    sheet_name = input.next();
                    for (int i = 0; i < user_list.size(); i++) {
                        if (user_list.get(i).get_user_name().equals(user_name)) {
                            System.out.println("");
                            System.out.print(user_name);
                            System.out.print(" ");
                            System.out.print(sheet_name);
                            System.out.print(" ");
                            System.out.println(user_list.get(i).get_sheet(sheet_name).change_access_status());
                            System.out.println("");
                            break;
                        }
                    }
                    break;
                case 6:
                    input.close();
                    return;
            }
        }
    }
}

// @SuppressWarnings("unused")
class sheet {
    private int temp;
    private String sheet_name;
    private String access_status = "Editable";
    private double[][] data = new double[5][5];

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

    public void change_data(int y_pos, int x_pos, double value) {
        if (access_status.equals("Editable")) {
            data[y_pos][x_pos] = value;
        } else {
            System.out.println("");
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
}

// @SuppressWarnings("unused")
class user {
    private sheet temp;
    private String user_name;
    private ArrayList<sheet> sheet_list = new ArrayList<sheet>();

    user(String user_name) {
        this.user_name = user_name;
    }

    public String get_user_name() {
        return user_name;
    }

    public void add_sheet(sheet new_sheet) {
        sheet_list.add(new_sheet);
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