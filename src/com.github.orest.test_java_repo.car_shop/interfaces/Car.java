package com.github.orest.test_java_repo.car_shop.interfaces;

import lombok.*;

@AllArgsConstructor
@Data
public class Car {
    private int id;
    private String brand;
    private String model;
    private String color;
    private String damage;
    private int price;
    private int quantity;
}
