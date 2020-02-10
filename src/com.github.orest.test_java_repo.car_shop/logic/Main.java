package com.github.orest.test_java_repo.car_shop.logic;
import com.github.orest.test_java_repo.car_shop.interfaces.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Car> allCars = CarStorage.getAvailableCars();

        String message = "Please enter car brand you want to search for.  (q to Quit or all to see all cars list): ";
        String brand;

        Scanner input = new Scanner(System.in);

        System.out.println(message);
        brand = input.nextLine();
        if (brand.equals("all")){
            CarShop.printAllCars(allCars);
            System.out.println("\n \n" +  message);
            brand = input.nextLine();
        }

        while (!brand.equals("q")) {
            if (brand.equals("all")){
                CarShop.printAllCars(allCars);
                System.out.println("\n \n" +  message);
                brand = input.nextLine();
            } else {
                CarShop.getBrand(brand, allCars);
                System.out.println("\n \n " + message);
                brand = input.nextLine();
            }
        }
    }
}
