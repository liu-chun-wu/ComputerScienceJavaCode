/*
Practice 3
Name: 劉俊吾
Student Number: 111502522
Course 2023-CE1004-A 
*/

package P3_111502522;

import java.util.Scanner;

public class P3_111502522 {

    public static void main(String[] args) {

        System.out.println("please input the goods info id/name/price:");

        Scanner input = new Scanner(System.in);
        String id = input.next();
        String name = input.next();
        int price = input.nextInt();

        goods goods_obj = new goods(id, name, price);

        int command;
        while (true) {

            System.out.println("1.show the current price 2.change the price 3.exit the system:");

            command = input.nextInt();
            switch (command) {
                case 1:
                    System.out.print("the current price is ");
                    System.out.println(goods_obj.getPrice());
                    break;
                case 2:
                    System.out.println("please input the new price:");

                    price = input.nextInt();
                    goods_obj.changePrice(price);
                    break;
                case 3:
                    input.close();
                    return;
            }
        }

    }

}

@SuppressWarnings("unused")
class goods {

    private String id;
    private String name;
    private int price;

    goods(String id, String name, int price) {

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getPrice() {

        return price;
    }

    public void changePrice(int price) {

        this.price = price;
    }
}