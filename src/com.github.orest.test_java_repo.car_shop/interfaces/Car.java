package com.github.orest.test_java_repo.car_shop.interfaces;
import java.util.*;

public class Car {
    public int id;
    public String brand;
    public String model;
    public String color;
    public String damage;
    public int price, quantity;

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
