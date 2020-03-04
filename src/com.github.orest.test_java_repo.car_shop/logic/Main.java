package com.github.orest.test_java_repo.car_shop.logic;
import com.github.orest.test_java_repo.car_shop.interfaces.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Car> allCars = CarStorage.getAvailableCars();

        String message = "Please enter car brand you want to search for.  ('q' to Quit, 'all' to see all cars list, 'a' to start auction): ";
        String text;

        Scanner input = new Scanner(System.in);

        System.out.println(message);
        text = input.nextLine();
        if (text.equals("all")){
            CarShop.printAllCars(allCars);
            System.out.println("\n \n" +  message);
            text = input.nextLine();
        }

        while (!text.equals("q")) {
            if (text.equals("all")){
                CarShop.printAllCars(allCars);
                System.out.println("\n \n" +  message);
                text = input.nextLine();
            } else if (text.equals("a")) {
                CarShop.startAuction(allCars);
                System.out.println("\n \n " + message);
                text = input.nextLine();
            } else {
                CarShop.getBrand(text, allCars);
                System.out.println("\n \n " + message);
                text = input.nextLine();
            }
        }
    }
}
