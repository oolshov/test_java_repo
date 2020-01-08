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

    public Map<String, String> getCarFields() {
        Map<String, String> someMap = new HashMap<>();
        someMap.put("id", Integer.toString(this.id));
        someMap.put("brand", this.brand);
        someMap.put("model", this.model);
        someMap.put("color", this.color);
        someMap.put("damage", this.damage);
        someMap.put("price", Integer.toString(this.price));
        someMap.put("quantity", Integer.toString(this.quantity));
        return someMap;
    }
}
