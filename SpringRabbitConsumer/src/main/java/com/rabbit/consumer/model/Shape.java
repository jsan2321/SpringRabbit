package com.rabbit.consumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shape {
    private String name;
    private Integer numberOfSides;
}
