package com.cinema.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    String NAME;
    String PASSWORD;


    public static final Admin DEFAULT_ADMIN = new Admin("Admin","2208");


}

