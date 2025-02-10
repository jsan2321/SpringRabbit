package com.rabbit.consumer.model;

import lombok.*;

public class Shape {
    private String name;
    private Integer numberOfSides;

    public Shape() {
    }

    public Shape(String name, Integer numberOfSides) {
        this.name = name;
        this.numberOfSides = numberOfSides;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfSides() {
        return numberOfSides;
    }

    public void setNumberOfSides(Integer numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    @Override
    public String toString() {
        return "Shape{" +
                       "name='" + name + '\'' +
                       ", numberOfSides=" + numberOfSides +
                       '}';
    }
}
