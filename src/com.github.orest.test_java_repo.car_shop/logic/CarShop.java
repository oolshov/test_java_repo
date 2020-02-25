package com.github.orest.test_java_repo.car_shop.logic;

import com.github.orest.test_java_repo.car_shop.interfaces.*;
import java.util.ArrayList;
import java.util.List;

public class CarShop {

    // this method search for available brand and return Car array
    public static List<Car> getBrand(String brand, List<Car> allCars) throws IllegalArgumentException {

        if (allCars == null || allCars.size() < 1) {
            System.out.println("Something went wrong, list of cars is: null or 0 length");
            return allCars;
        }

        List<Car> foundCars = new ArrayList<>();
        for (int i = 0; i < allCars.size(); i++) {
            if (allCars.get(i).getBrand().contains(brand)) {
                foundCars.add(allCars.get(i));
            }
        }

        if (foundCars.size() > 0) {
            System.out.println("At this moment we have - " + foundCars.size() + " records with brand - " + brand);
            System.out.println("Available models is: ");

            // Try to use .foreach like foundCars.forEach(i -> System.out.println(i));
            foundCars.forEach(car -> System.out.println(car.getModel() + " - " + car.getQuantity() + " car(s), color - " + car.getColor() + ", price begins from - " + car.getPrice()));

        } else {
            System.out.println("Sorry, no available brand - " + brand + " at this moment or you entered wrong text, please try again.");
        }
        return foundCars;
    }

    public static void printAllCars(List<Car> allCars) {

        if (allCars == null || allCars.size() < 1) {
            System.out.println("Something went wrong, list of cars is: null or 0 length");
            return;
        }

        for (int i = 0; i < allCars.size(); i++) {
            System.out.println(allCars.get(i).getBrand() + " " + allCars.get(i).getModel() + " - " + allCars.get(i).getQuantity() + " car(s), color - " + allCars.get(i).getColor() + ", price begins from - " + allCars.get(i).getPrice());
        }
    }

}
