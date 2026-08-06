package com.cinema.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Customer {
    private String name;
    private int age;
    private double cash;
}
