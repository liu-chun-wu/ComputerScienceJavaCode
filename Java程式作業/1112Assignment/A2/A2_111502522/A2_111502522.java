/*
Assignment 1
Name: 劉俊吾
Student Number: 111502522
Course 2023-CE1002-A
*/
package A2_111502522;

import java.lang.StringBuilder;
import java.util.Scanner;

public class A2_111502522 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();

		StringBuilder str_reverse = new StringBuilder(str);
		str_reverse.reverse();

		if (test(str)) {
			System.out.println("Yes");
		} else {
			if (delete_one_word(str)) {
				System.out.println("Yes if a word is deleted");
			} else {
				System.out.println("No");
			}
		}

	}

	public static boolean test(String str) {
		StringBuilder str_reverse = new StringBuilder(str);
		str_reverse.reverse();

		if (str.toLowerCase().equals(str_reverse.toString().toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean delete_one_word(String str) {
		for (int i = 0; i < str.length(); i++) {
			String test_str = new String(str.substring(0, i) + str.substring(i + 1, str.length()));
			if (test(test_str)) {
				return true;
			}
		}
		return false;
	}

}
