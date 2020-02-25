package com.github.orest.test_java_repo.car_shop.logic;

import com.github.orest.test_java_repo.car_shop.interfaces.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CarShop {

    public static void validateCars(List<Car> allCars){
        if (allCars == null || allCars.size() < 1) {
            System.out.println("Something went wrong, list of cars is: null or 0 length");
            return;
        }
    }

    // this method search for available brand and return Car array
    public static List<Car> getBrand(String brand, List<Car> allCars) throws IllegalArgumentException {

        validateCars(allCars);

        List<Car> foundCars = new ArrayList<>();
        for (int i = 0; i < allCars.size(); i++) {
            if (allCars.get(i).getBrand().equals(brand)) {
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

    public static List<Car> getModel(String model, List<Car> allCars) throws IllegalArgumentException {

        validateCars(allCars);

        List<Car> foundModel = new ArrayList<>();
        for (int i = 0; i < allCars.size(); i++) {
            if (allCars.get(i).getModel().equals(model)) {
                foundModel.add(allCars.get(i));
            }
        }

        if (foundModel.size() > 0) {
            System.out.println("At this moment we have - " + foundModel.get(0).getQuantity() + " cars of " + model + " with price - " + foundModel.get(0).getPrice());
        } else {
            System.out.println("Sorry, no available model - " + model + " at this moment or you entered wrong text, please try again.");
        }
        return foundModel;
    }

    public static void printAllCars(List<Car> allCars) {

        validateCars(allCars);

        for (int i = 0; i < allCars.size(); i++) {
            System.out.println(allCars.get(i).getBrand() + " " + allCars.get(i).getModel() + " - " + allCars.get(i).getQuantity() + " car(s), color - " + allCars.get(i).getColor() + ", price begins from - " + allCars.get(i).getPrice());
        }
    }

    public static void startAuction(List<Car> allCars) {

        validateCars(allCars);
        int price = 0;
        String text;
        String modelMessage = "\n\nPlease enter car Model you want to participate in auction ('q' to Quit auction) :";
        String priceMessage = "\n\nPlease enter price for the car in +- 10% range of price ('q' to Quit auction) :";
        printAllCars(allCars);

        Scanner input = new Scanner(System.in);
        System.out.println(modelMessage);
        text = input.nextLine();

        while (!text.equals("q")) {
            String winner = "";
            List<Car> foundModel = new ArrayList<>();
            foundModel = getModel(text, allCars);

            if (foundModel.size() > 0) {
                System.out.println(priceMessage);
                if (!input.hasNextInt()) {
                    System.out.println("Please enter a number, you entered - '" + input.nextInt() + "'");
                } else {
                    price = input.nextInt();
                    winner = getRandomPriceForAuction(price, foundModel);
                    if (winner.equals("user")) {
                        System.out.println("You won - " + foundModel.get(0).getBrand() + " " + foundModel.get(0).getModel() + " for the: " + price + " USD");
                    } else {
                        System.out.println("Sorry You didn't won");
                    }
                }
                System.out.println(modelMessage);
                text = input.nextLine();
            } else {
                System.out.println(modelMessage);
                text = input.nextLine();
            }
        }
    }

    public static String getRandomPriceForAuction(int price, List<Car> foundModel) {
        List<Integer> randomPrice = new ArrayList<>();
        int max = foundModel.get(0).getPrice() + Math.round(foundModel.get(0).getPrice() / 10);
        int min = foundModel.get(0).getPrice() - Math.round(foundModel.get(0).getPrice() / 10);
        String winner = "user";
        for (int i = 0; i < 2; i++) {
            randomPrice.add(new Random().nextInt(max) + min);
        }
        if (randomPrice.get(0) < price && randomPrice.get(1) < price)  {
            winner = "system";
        }
        return winner;
    }
}
