package com.github.orest.test_java_repo.car_shop.logic;

import com.github.orest.test_java_repo.car_shop.interfaces.*;
import java.util.ArrayList;
import java.util.List;

public class AllCars {
    public static List<Car> getAvailableCars() {
        List<Car> allCars = new ArrayList<>();
        allCars.add(new Car (1, "Mercedes", "A-Class", "Black", "no damage", 32500, 2));
        allCars.add(new Car (2, "Mercedes", "C-Class", "Red", "left wing", 37000, 1));
        allCars.add(new Car (3, "Mercedes", "E-Class", "Black", "no damage", 53000, 3));
        allCars.add(new Car (4, "Audi", "A4 Sedan", "Blue", "no damage", 39000, 4));
        allCars.add(new Car (5, "Audi", "A5 Sportback", "Grey", "no damage", 44200, 3));
        allCars.add(new Car (6, "Audi", "A7", "Silver", "no damage", 69000, 2));
        allCars.add(new Car (7, "Reno", "Megan", "Black", "no damage", 14000, 5));
        allCars.add(new Car (8, "Reno", "Duster", "Green", "no damage", 15200, 2));
        allCars.add(new Car (9, "Reno", "Logan", "White", "front bumper", 10700, 1));
        allCars.add(new Car (10, "BMW", "X5 M50d", "Black", "no damage", 108000, 4));
        allCars.add(new Car (11, "BMW", "X1 xDrive20i", "Grey", "no damage", 44000, 2));
        allCars.add(new Car (12, "BMW", "xDrive 320i", "Blue", "no damage", 52000, 2));
        allCars.add(new Car (13, "VW", "Polo", "White", "no damage", 14700, 2));
        allCars.add(new Car (14, "VW", "Passat B8", "White", "no damage", 44000, 2));
        allCars.add(new Car (15, "VW", "Jetta", "Black", "rear bumper", 14000, 2));
        return allCars;
    }
}
