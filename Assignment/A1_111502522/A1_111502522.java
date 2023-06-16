/*
Assignment 1
Name: 劉俊吾
Student Number: 111502522
Course 2023-CE1001-A
*/
package A1_111502522;

import java.util.Scanner;

public class A1_111502522 {

	public static void main(String[] args) {

		double height;
		double weight;
		Scanner s = new Scanner(System.in);

		height = s.nextDouble();
		weight = s.nextDouble();
		s.close();

		height = height / 100;
		double bmi = weight / (height * height);

		if (bmi > 35) {
			System.out.print("重度肥胖");
		} else if (bmi >= 30) {
			System.out.print("中度肥胖");
		} else if (bmi >= 27) {
			System.out.print("輕度肥胖");
		} else if (bmi >= 24) {
			System.out.print("過重");
		} else {
			System.out.print("正常");
		}

	}

}
