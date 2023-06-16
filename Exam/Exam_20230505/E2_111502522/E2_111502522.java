//20230505
package Exam.Exam_20230505.E2_111502522;

import java.util.*;

public class E2_111502522 {
    public static void main(String[] args) {
        ArrayList<things> shopcar = new ArrayList<things>();
        int id;
        String name;
        int price;
        int num;
        int total;
        Scanner input = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("1.add 2.query 3.update 4.pay 5.exit");
            command = input.next();
            if (command.equals("1")) {
                System.out.println("input goods id:");
                id = input.nextInt();
                System.out.println("input goods name:");
                name = input.next();
                System.out.println("input goods price:");
                price = input.nextInt();
                System.out.println("input goods num:");
                num = input.nextInt();
                things new_things = new things(id, name, price, num);
                shopcar.add(new_things);
                System.out.println("your goods:" + name + " is added to the shopping cart");
                Collections.sort(shopcar, new thingsSort());
            } else if (command.equals("2")) {
                System.out.println("==========shopping cart==========");
                System.out.println("id     name        price      num");
                for (int i = 0; i < shopcar.size(); i++) {
                    shopcar.get(i).show();
                }
            } else if (command.equals("3")) {
                System.out.println("input goods id:");
                id = input.nextInt();
                boolean flag = false;
                for (int i = 0; i < shopcar.size(); i++) {
                    if (shopcar.get(i).get_id() == id) {
                        System.out.println("input goods new num:");
                        num = input.nextInt();
                        shopcar.get(i).change_num(num);
                        System.out.println("finish");
                        System.out.println("==========shopping cart==========");
                        System.out.println("id     name        price      num");
                        for (int j = 0; j < shopcar.size(); j++) {
                            shopcar.get(j).show();
                        }
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    System.out.println("not found");
                }
            } else if (command.equals("4")) {
                total = 0;
                for (int j = 0; j < shopcar.size(); j++) {
                    total += shopcar.get(j).get_price() * shopcar.get(j).get_num();
                }
                System.out.println("==========shopping cart==========");
                System.out.println("id     name        price      num");
                for (int j = 0; j < shopcar.size(); j++) {
                    shopcar.get(j).show();
                }
                System.out.println("total price:" + total);
            } else if (command.equals("5")) {
                input.close();
                break;
            } else {
                System.out.println("no such function");
            }
        }
    }
}

class things {
    private int id;
    private String name;
    private int price;
    private int num;

    things(int id, String name, int price, int num) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.num = num;
    }

    public int get_id() {
        return id;
    }

    public void change_num(int new_num) {
        this.num = new_num;
    }

    public int get_price() {
        return price;
    }

    public int get_num() {
        return num;
    }

    public void show() {
        System.out.printf("%-7d%-12s%-11d%d\n", id, name, price, num);
    }
}

class thingsSort implements Comparator<things> {
    public int compare(things a, things b) {
        return a.get_id() - b.get_id();
    }
}