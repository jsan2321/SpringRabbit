package com.rabbit.provider.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a Shape entity with a name and the number of sides.
 * This class is used to model shape data that can be published to RabbitMQ.
 */
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
public class Shape {

    /**
     * The name of the shape.
     * This field is mapped to the "name" property in JSON.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The number of sides of the shape.
     * This field is mapped to the "numberOfSides" property in JSON.
     */
    @JsonProperty("numberOfSides")
    private Integer numberOfSides;
}