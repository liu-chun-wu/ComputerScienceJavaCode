/*
 * Practice 14
 * Name: 劉俊吾
 * Student Number: 111502522
 * Course 2023-CE1004-A
 */
package P14_111502522;

import java.util.Scanner;

public class P14_111502522 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        double first_num;
        String operator;
        double second_num;
        System.out.print("Enter the first number: ");
        while (true) {
            try {
                input = scanner.nextLine();
                first_num = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number! Please enter again: ");
            }
        }
        System.out.print("Enter the operator (+, -, *, or /): ");
        while (true) {
            try {
                operator = scanner.nextLine();
                if (!(operator.equals("+")) && !(operator.equals("-")) && !(operator.equals("*"))
                        && !(operator.equals("/"))) {
                    throw new IllegalArgumentException("Invalid operator! Please enter again: ");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
        System.out.print("Enter the second number: ");
        while (true) {
            try {
                input = scanner.nextLine();
                second_num = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number! Please enter again: ");
            }
        }
        scanner.close();
        try {
            switch (operator) {
                case "+":
                    System.out.printf("Result: %.1f\n", first_num + second_num);
                    break;
                case "-":
                    System.out.printf("Result: %.1f\n", first_num - second_num);
                    break;
                case "*":
                    System.out.printf("Result: %.1f\n", first_num * second_num);
                    break;
                case "/":
                    if (second_num == 0) {
                        throw new IllegalArgumentException("Divisor cannot be zero!");
                    }
                    System.out.printf("Result: %.1f\n", first_num / second_num);
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}