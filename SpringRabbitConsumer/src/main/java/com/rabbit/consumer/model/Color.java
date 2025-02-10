package com.rabbit.consumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Color {
    private String name;
    private String hex;

    public Color() {
    }

    public Color(String hex, String name) {
        this.hex = hex;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    @Override
    public String toString() {
        return "Color{" +
                       "name='" + name + '\'' +
                       ", hex='" + hex + '\'' +
                       '}';
    }
}
