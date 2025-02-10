package com.rabbit.provider.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a Color entity with a name and a hexadecimal color code.
 * This class is used to model color data that can be published to RabbitMQ.
 */
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
public class Color {

    /**
     * The name of the color.
     * This field is mapped to the "name" property in JSON.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The hexadecimal representation of the color.
     * This field is mapped to the "hex" property in JSON.
     */
    @JsonProperty("hex")
    private String hex;
}