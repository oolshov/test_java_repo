package com.example.helloworld;
import com.sun.deploy.security.SelectableSecurityManager;
import org.apache.commons.lang3.ArrayUtils;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class CarShop {

    public static void main(String[] args) {

        Car car1 =  new Car (1, "Mercedes", "A-Class", "Black", "no damage", 32500, 2);
        Car car2 =  new Car (2, "Mercedes", "C-Class", "Red", "left wing", 37000, 1);
        Car car3 =  new Car (3, "Mercedes", "E-Class", "Black", "no damage", 53000, 3);
        Car car4 =  new Car (4, "Audi", "A4 Sedan", "Blue", "no damage", 39000, 4);
        Car car5 =  new Car (5, "Audi", "A5 Sportback", "Grey", "no damage", 44200, 3);
        Car car6 =  new Car (6, "Audi", "A7", "Silver", "no damage", 69000, 2);
        Car car7 =  new Car (7, "Reno", "Megan", "Black", "no damage", 14000, 5);
        Car car8 =  new Car (8, "Reno", "Duster", "Green", "no damage", 15200, 2);
        Car car9 =  new Car (9, "Reno", "Logan", "White", "front bumper", 10700, 1);
        Car car10 =  new Car (10, "BMW", "X5 M50d", "Black", "no damage", 108000, 4);
        Car car11 =  new Car (11, "BMW", "X1 xDrive20i", "Grey", "no damage", 44000, 2);
        Car car12 =  new Car (12, "BMW", "xDrive 320i", "Blue", "no damage", 52000, 2);
        Car car13 =  new Car (13, "VW", "Polo", "White", "no damage", 14700, 2);
        Car car14 =  new Car (14, "VW", "Passat B8", "White", "no damage", 44000, 2);
        Car car15 =  new Car (15, "VW", "Jetta", "Black", "rear bumper", 14000, 2);
        Car[] allCars = {car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12, car13, car14, car15};

        Car[] foundCars = getAvailableCars(allCars);
    }

    // this method search for available brand and return Car array
    public static Car[] getBrand(String brand, Car[] allCars) {

        for (int i = 0; i < allCars.length; i++) {
            if (!Arrays.asList(allCars[i].brand).contains(brand)) {
                allCars = ArrayUtils.remove(allCars, i);
                i--;
            }
        }
        if (allCars.length > 0) {
            System.out.println("At this moment we have - " + allCars.length + " records with brand - " + brand);
            System.out.println("Available models is: ");
            for (int i = 0; i < allCars.length; i++) {
                System.out.println(allCars[i].model + " - " + allCars[i].quantity + " car(s), color - " + allCars[i].color + ", price begins from - " + allCars[i].price);
            }

        } else {
            System.out.println("Sorry, no available brand - " + brand + " at this moment or you entered wrong text, please try again.");
        }
        return allCars;
    }

    public static void printAllCars(Car[] allCars) {
        for (int i = 0; i < allCars.length; i++) {
            System.out.println(allCars[i].brand + allCars[i].model + " - " + allCars[i].quantity + " car(s), color - " + allCars[i].color + ", price begins from - " + allCars[i].price);
        }
    }

    // scanner method calling search method
    public static Car[] getAvailableCars(Car[] allCars) {

        if (allCars == null || allCars.length < 1) {
            System.out.println("method getMinMaxValue parameter 'numbers' is: null or 0 length");
            return allCars;
        }
        String message = "Please enter car brand you want to search for.  (q to Quit or all to see all cars list): ";

        Scanner input = new Scanner(System.in);
        String brand;
        System.out.println(message);
        brand = input.nextLine();
        if (brand.equals("all")){
            printAllCars(allCars);
            System.out.println("\n \n" +  message);
            brand = input.nextLine();
        }

        while (!brand.equals("q")) {
            if (brand.equals("all")){
                printAllCars(allCars);
                System.out.println("\n \n" +  message);
                brand = input.nextLine();
            } else {
                allCars = getBrand(brand, allCars);
                System.out.println("\n \n " + message);
                brand = input.nextLine();
            }
        }
        return allCars;
    }

    public static class Car {
        int id;
        String brand, model, color, damage;
        int price, quantity;
        public Car (int id, String brand, String model, String color, String damage, int price, int quantity) {
            this.id = id;
            this.brand = brand;
            this.model = model;
            this.color = color;
            this.damage = damage;
            this.price = price;
            this.quantity = quantity;
        }
    }
}
