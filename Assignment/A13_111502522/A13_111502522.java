/*
 * Assignment 13
 * Name: 劉俊吾
 * Student Number: 111502522
 * Course 2023-CE1002-A
 */
package A13_111502522;

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

public class A13_111502522 {
    public static void main(String[] args) {
        ArrayList<BaseCar> car_list = new ArrayList<BaseCar>();
        int track;
        int car_number;
        int car_type;
        String driver;
        int time_count;
        int slowest_car_postion;
        int winner_index;
        int winner_number;
        boolean game_over;
        Scanner input = new Scanner(System.in);
        track = input.nextInt();
        car_number = input.nextInt();
        for (int i = 0; i < car_number; i++) {
            driver = input.next();
            car_type = input.nextInt();
            if (car_type == 1) {
                Benz car = new Benz(driver, 1);
                car_list.add(car);
            } else if (car_type == 2) {
                BMW car = new BMW(driver, 2);
                car_list.add(car);
            } else {
                Mazda car = new Mazda(driver, 3);
                car_list.add(car);
            }
        }
        time_count = 1;
        game_over = false;
        winner_number = 0;
        winner_index = 0;
        while (true) {
            slowest_car_postion = track;
            if (time_count % 10 == 1 && time_count > 1) {
                for (int i = 0; i < car_list.size(); i++) {
                    slowest_car_postion = Math.min(slowest_car_postion, car_list.get(i).get_position());
                }
                for (int i = 0; i < car_list.size(); i++) {
                    if (car_list.get(i).get_position() == slowest_car_postion) {
                        car_list.get(i).set_boost_speed();
                    }
                }
            }
            for (int i = 0; i < car_list.size(); i++) {
                car_list.get(i).car_run();
            }
            for (int i = 0; i < car_list.size(); i++) {
                if (car_list.get(i).get_position() >= track) {
                    winner_number++;
                    winner_index = i;
                    game_over = true;
                }
            }
            if (game_over == true) {
                if (winner_number > 1) {
                    System.out.print("More than 1 winner! ");
                } else {
                    System.out.print(car_list.get(winner_index).get_driver() + " wins! ");
                }
                show_all_car(car_list);
                input.close();
                break;
            }
            if (time_count % 10 == 0 && time_count > 0) {
                System.out.print("When " + time_count + "sec starts, ");
                show_all_car(car_list);
                for (int i = 0; i < car_list.size(); i++) {
                    car_list.get(i).set_normal_speed();
                }
            }
            time_count++;
        }
    }

    public static void show_all_car(ArrayList<BaseCar> car_list) {
        for (int i = 0; i < car_list.size(); i++) {
            car_list.get(i).show_position();
        }
        System.out.println();
    }
}

class BaseCar {
    protected String driver = "";
    protected int speed = 0;
    protected int driver_boost;
    protected int boost = 0;

    protected int normal_speed = 0;
    protected int boosted_speed = 0;
    protected int position = 0;
    protected boolean boost_flag = false;

    BaseCar(String driver, int car_type) {
        this.driver = driver;
        if (driver.equals("A")) {
            normal_speed += 3;
        } else if (driver.equals("B")) {
            normal_speed += 2;
        } else if (driver.equals("C")) {
            normal_speed += 1;
        } else if (driver.equals("D")) {
            normal_speed += 3;
        } else if (driver.equals("E")) {
            normal_speed += 10;
        } else if (driver.equals("F")) {
            normal_speed += 2;
        } else if (driver.equals("G")) {
            normal_speed += 1;
        }
        if (car_type == 1) {
            normal_speed += 14;
            boost = 5;
        } else if (car_type == 2) {
            normal_speed += 8;
            boost = 8;
        } else {
            normal_speed += 11;
            boost = 2;
        }
        speed = normal_speed;
        boosted_speed = normal_speed + boost;
    }

    public void set_boost_speed() {
        speed = boosted_speed;
    }

    public void set_normal_speed() {
        speed = normal_speed;
    }

    public int get_position() {
        return position;
    }

    public String get_driver() {
        return driver;
    }

    public void car_run() {
        position += speed;
    }

    public void show_position() {
        System.out.print(driver + ":" + position + "m ");
    }
}

class Benz extends BaseCar {
    Benz(String driver, int car_type) {
        super(driver, car_type);
    }
}

class BMW extends BaseCar {
    BMW(String driver, int car_type) {
        super(driver, car_type);
    }
}

class Mazda extends BaseCar {
    Mazda(String driver, int car_type) {
        super(driver, car_type);
    }
}