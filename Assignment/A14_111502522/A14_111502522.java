/*
 * Assignment 14
 * Name: 劉俊吾
 * Student Number: 111502522
 * Course 2023-CE1002-A
 */
package A14_111502522;

import java.util.Scanner;

public class A14_111502522 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        double first_num;
        String operator;
        double second_num;
        while (true) {
            try {
                System.out.println("Enter a calculation (or enter \"quit\" to exit): ");
                input = scanner.nextLine();

                if (input.equals("quit")) {
                    System.out.println("Program terminated.");
                    break;
                }

                String[] input_parts = input.split(" ");
                if (input_parts.length != 3) {
                    throw new IllegalArgumentException("Invalid calculation! Please enter again.");
                }

                first_num = Double.parseDouble(input_parts[0]);
                operator = input_parts[1];
                second_num = Double.parseDouble(input_parts[2]);

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
                    default:
                        throw new IllegalArgumentException("Invalid operator!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}