package com.github.orest.car_shop.service;
import com.github.orest.car_shop.model.Car;
import com.github.orest.car_shop.storage.CarStorage;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Car> allCars = CarStorage.getAvailableCars();
        String text;

        Scanner input = new Scanner(System.in);

        System.out.println(CarShop.getMessage("main"));
        text = input.nextLine();
        if (text.equals("all")){
            CarShop.printAllCars(allCars);
            System.out.println(CarShop.getMessage("main"));
            text = input.nextLine();
        }

        while (!text.equals("q")) {
            if (text.equals("all")){
                CarShop.printAllCars(allCars);
                System.out.println(CarShop.getMessage("main"));
                text = input.nextLine();
            } else if (text.equals("a")) {
                CarShop.startAuction(allCars, input);
                System.out.println(CarShop.getMessage("main"));
                text = input.nextLine();
            } else {
                CarShop.getBrand(text, allCars);
                System.out.println(CarShop.getMessage("main"));
                text = input.nextLine();
            }
        }
    }
}
