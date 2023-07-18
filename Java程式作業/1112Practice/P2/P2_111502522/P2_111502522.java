/*
Practice 2
Name: 劉俊吾
Student Number: 111502522
Course 2023-CE1004-A 
*/
package P2_111502522;

import java.util.Scanner;

public class P2_111502522 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();

		StringBuilder str_reverse = new StringBuilder(str);
		str_reverse.reverse();

		if (str.toLowerCase().equals(str_reverse.toString().toLowerCase())) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
