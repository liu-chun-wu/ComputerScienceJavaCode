/*
Assignment 3
Name: 劉俊吾
Student Number: 111502522
Course 2023-CE1002-A
*/
package A3_111502522;

import java.util.ArrayList;
import java.util.Scanner;

public class A3_111502522 {

	public static void main(String[] args) {

		store store_obj = new store();
		Scanner input = new Scanner(System.in);

		while (true) {

			String id;
			String name;
			int price;
			int amount;

			System.out.println("1.add goods 2.sell 3.show all item in store 4.show income 5.exit:");

			int command = input.nextInt();
			switch (command) {
				case 1:
					System.out.println("please input goods info id/name/price/amount:");

					id = input.next();
					name = input.next();
					price = input.nextInt();
					amount = input.nextInt();

					goods goods_obj = new goods(id, name, price, amount);
					store_obj.addItem(goods_obj);
					break;
				case 2:
					System.out.println("please input goods id and the sell amount:");

					id = input.next();
					amount = input.nextInt();

					store_obj.sell(id, amount);
					break;
				case 3:
					store_obj.showAll();
					break;
				case 4:
					store_obj.showIncome();
					break;
				case 5:
					input.close();
					return;
			}
		}
	}
}

class goods {

	public String id;
	private String name;
	private int price;
	public int amount;

	goods(String id, String name, int price, int amount) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public String getName() {

		return name;
	}

	public int getPrice() {

		return price;
	}
}

class store {

	private int money = 0;
	private ArrayList<goods> goodList = new ArrayList<goods>();

	public void addItem(goods goods_obj) {
		goodList.add(goods_obj);
	}

	public void sell(String id, int amount) {

		for (int i = 0; i < goodList.size(); i++) {

			if (goodList.get(i).id.equals(id)) {

				money += goodList.get(i).getPrice() * amount;
				goodList.get(i).amount -= amount;

				if (goodList.get(i).amount == 0) {

					goodList.remove(i);
				}
			}
		}
	}

	public void showAll() {

		for (int i = 0; i < goodList.size(); i++) {

			System.out.print(goodList.get(i).id);
			System.out.print(" ");
			System.out.print(goodList.get(i).getName());
			System.out.print(" ");
			System.out.print(goodList.get(i).getPrice());
			System.out.print(" ");
			System.out.println(goodList.get(i).amount);
		}
	}

	public void showIncome() {

		System.out.println(money);
	}
}